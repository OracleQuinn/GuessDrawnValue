package com.awardega.GuessDrawnValue.controllers;

import com.awardega.GuessDrawnValue.entities.Game;
import com.awardega.GuessDrawnValue.services.GameServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GuessGameController {
    GameServiceImpl gameService;
    Game game;

    @GetMapping("/guess/{guessNumber}")
    public String guessPage(@PathVariable int guessNumber) throws Exception{
        int secretNumber = game.drawFunction();
        String result = gameService.verifyGuess(secretNumber, guessNumber);
        return result;
    }
}

