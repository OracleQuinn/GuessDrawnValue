package com.awardega.GuessDrawnValue.controllers;

import com.awardega.GuessDrawnValue.entities.Player;
import com.awardega.GuessDrawnValue.repositories.PlayerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartGameController {
    PlayerRepository playerRepository;
    Player player = new Player();

    @GetMapping("/start")
    public String startGamePage() {
        player.getId();
        return "start";
    }
}

