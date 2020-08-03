package com.galvanize.dock_sandwich;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SandwichController {

    @GetMapping("/home")
    public String getHome() {
        return "Welcome Home!";
    }
}
