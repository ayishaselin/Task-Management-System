package com.ayishaselin.taskmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Spring searches:Which controller handles this URL?It finds:


public class HomeController { //java class name

    @GetMapping("/") //When the user visits the root URL this method will be called.
    public String home() {
        return "index";
    }
}