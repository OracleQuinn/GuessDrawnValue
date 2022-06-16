package com.awardega.GuessDrawnValue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The class that is the controller associated with the start page containing the instructions for moving around in the game.
 */
@Controller
public class StartGameController {
    @GetMapping("/start")
    public String startPage() {
        return "start";
    }
}

