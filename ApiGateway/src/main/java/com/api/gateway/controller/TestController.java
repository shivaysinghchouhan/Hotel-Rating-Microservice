package com.api.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Public Page!";
    }

    @GetMapping("/secured")
    public String securedPage() {
        return "You are authenticated! ✅";
    }
}
