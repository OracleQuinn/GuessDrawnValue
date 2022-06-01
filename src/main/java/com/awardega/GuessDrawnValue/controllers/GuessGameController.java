package com.awardega.GuessDrawnValue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GuessGameController {

    @GetMapping("/guess")
    public String startGamePage() {
        return "guess";
    }
}
