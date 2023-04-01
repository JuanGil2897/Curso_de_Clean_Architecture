package dev.fennex.clean.presentation.controllers;

import dev.fennex.clean.domain.interactors.*;
import dev.fennex.clean.domain.model.Todo;
import dev.fennex.clean.presentation.controllers.error.RequestError;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @GetMapping(
            value = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<?> getAll() {
        GetAllTodosUseCase useCase = new GetAllTodosUseCase();

        try {
            return ResponseEntity.ok().body(useCase.execute());
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(new RequestError(e.getMessage()));
        }
    }


    @PostMapping(
            value = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<?> add(@RequestBody AddTodoRequest request) {
        String content = request.content;

        // Set todo data
        Todo todo = new Todo();

        todo.content = content;

        // Create use case and assign todo
        AddTodoUseCase useCase = new AddTodoUseCase();
        useCase.todo = todo;

        try {
            return ResponseEntity.ok().body(useCase.execute());
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(new RequestError(e.getMessage()));
        }
    }
    
    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<?> get(@PathVariable(value="id") String id) {

        GetTodoUseCase useCase = new GetTodoUseCase();

        useCase.id = id;

        try {
            return ResponseEntity.ok().body(useCase.execute());
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(new RequestError(e.getMessage()));
        }
    }
    
    @PutMapping(
            value = "/{id}/complete",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<?> complete(@PathVariable(value="id") String id) {

        CompleteTodoUseCase useCase = new CompleteTodoUseCase();

        useCase.id = id;

        try {
            return ResponseEntity.ok().body(useCase.execute());
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(new RequestError(e.getMessage()));
        }
    }

    @DeleteMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<?> delete(@PathVariable(value="id") String id) {

        DeleteTodoUseCase useCase = new DeleteTodoUseCase();

        useCase.id = id;

        try {
            return ResponseEntity.ok().body(useCase.execute());
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(new RequestError(e.getMessage()));
        }
    }
}

class AddTodoRequest {
    public String content;
}
