package com.awardega.GuessDrawnValue.services;

import com.awardega.GuessDrawnValue.entities.Player;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameServiceImplTest {
    GameServiceImpl gameService;

    @BeforeEach
    void setUp() {
        System.out.println("Set up");
        gameService = new GameServiceImpl();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tear down");
    }

    @Test
    void verifyGuess() {
        Player player = new Player();
        String result = gameService.verifyGuess(10,5);
        Assert.assertEquals("Too small 🙁 ", result);

        String result1 = gameService.verifyGuess(10,15);
        Assert.assertEquals("Too big 😐 ", result1);

        String result2 = gameService.verifyGuess(10,10);
        Assert.assertEquals("Congratulations! You win!", result2);
    }
}