package com.galvanize.dock_sandwich;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SandwichController {
    private SandwichRepository repository;

    @Autowired
    public SandwichController(SandwichRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/home")
    public String getHome() {
        return "Welcome Home!";
    }

    @GetMapping("/sandwiches")
    public List<Sandwich> getAllSandwiches() {
        return repository.findAll();
    }

    @PostMapping("/sandwiches")
    public Sandwich createSandwich(@RequestBody Sandwich sandwich) {
        return repository.save(sandwich);
    }
}