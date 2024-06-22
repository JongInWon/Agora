package com.agora.agora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello Agora";
    }

    @GetMapping("/articles")
    public String articles() {
        return "articles";
    }
}
