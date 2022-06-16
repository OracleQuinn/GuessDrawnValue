package com.awardega.GuessDrawnValue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The class that is the controller associated with the welcome page.
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage() {
        return "home";
    }
}

