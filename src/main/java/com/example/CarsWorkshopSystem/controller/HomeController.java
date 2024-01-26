package com.example.CarsWorkshopSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // handler method to handle home page request
    @GetMapping("/index")
    public String home() {
        return "index";
    }

    // handler method to handle login selection
    @GetMapping("/login")
    public String loginSelection() {
        return "loginSelection";
    }
}
