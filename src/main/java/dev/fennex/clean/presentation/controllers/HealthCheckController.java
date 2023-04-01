package dev.fennex.clean.presentation.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HealthCheckController {
    @RequestMapping(value="/", method=RequestMethod.GET)
    @ResponseBody
    public HealthCheckResponse index() {
        return new HealthCheckResponse();
    }

    static class HealthCheckResponse {
        public Boolean success = true;
    }

    @GetMapping(path = "getStringTest", produces = { "application/json", "application/xml" })
    public String index2() {
        return String.format("%1$s-%2$s", "Version App","1");
    }
}

