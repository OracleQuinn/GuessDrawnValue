package com.awardega.GuessDrawnValue.controllers;

import com.awardega.GuessDrawnValue.entities.Player;
import com.awardega.GuessDrawnValue.services.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/")
public class GuessGameController {
    @Autowired
    GameServiceImpl gameService;

    @GetMapping("game/{nick}")
    public ResponseEntity<Player> getPlayer(@PathVariable String nick) {
        return ResponseEntity.ok(gameService.getPlayer(nick));
    }

    @PostMapping("game")
    public ResponseEntity<Player> addNewPlayer(@RequestBody Player player) {
        return ResponseEntity.created(URI.create("/" + gameService.addNewPlayer(player))).build();
    }

    @GetMapping("guess/{nick}/{number}")
    public ResponseEntity<String> startingGame(@PathVariable String nick, @PathVariable Integer number) {
        return ResponseEntity.ok(gameService.startingGame(nick, number));
    }
    @GetMapping("best10")
    public ResponseEntity<List<Player>> getBest10() {

        return ResponseEntity.ok(gameService.get10BestPlayers());
    }

}
