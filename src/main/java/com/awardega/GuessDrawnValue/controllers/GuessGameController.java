package com.awardega.GuessDrawnValue.controllers;

import com.awardega.GuessDrawnValue.entities.Player;
import com.awardega.GuessDrawnValue.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(path = "/start")
public class GuessGameController {
    @Autowired
    GameService gameService;

    /**
     * The method that passes the user ID as a parameter to the GET method, returning the current information about the player.
     * @param id
     * @return
     */
    @GetMapping("/startGame/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable String id) {
        return ResponseEntity.ok(gameService.getPlayer(id));
    }

    /**
     * The method to initialize the user to which the ID should be passed.
     * @param player
     * @return
     */
    @PostMapping("/startGame")
    public ResponseEntity<Player> addNewPlayer(@RequestBody Player player) {
        return ResponseEntity.created(URI.create("/" + gameService.addNewPlayer(player))).build();
    }

    /**
     * Method accepted by GET ID of the player and the number that the player gives to guess.
     * The method returns information about the result of the comparison in GameService (startingGame) which binds to Game (guessedOrNot).
     * @param id
     * @param number
     * @return
     */
    @GetMapping("/guessGame/{id}/{number}")
    public ResponseEntity<String> startingGame(@PathVariable String id, @PathVariable Integer number) {
        return ResponseEntity.ok(gameService.startingGame(id, number));
    }

    /**
     * A method that reports the top 10 player scores.
     * @return
     */
    @GetMapping("/best10")
    public ResponseEntity<List<Player>> best10() {

        return ResponseEntity.ok(gameService.best10Players());
    }
}
