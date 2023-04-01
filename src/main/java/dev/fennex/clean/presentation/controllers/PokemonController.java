package dev.fennex.clean.presentation.controllers;

import dev.fennex.clean.model.Root;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pokemon")
public class PokemonController {
    @GetMapping(path = "getbyname", produces = { "application/json", "application/xml" })
    public Root getbyname(String name){
        Root objRoot = new Root();
        return objRoot;
    }

    @GetMapping(path = "getStringTest", produces = { "application/json", "application/xml" })
    public String index() {
        return String.format("%1$s-%2$s", "Version App","1");
    }
}
