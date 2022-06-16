package com.awardega.GuessDrawnValue.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player;

    @BeforeEach
    void setUp() {
        System.out.println("Set up");
        player = new Player();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tear down");
    }

    @Test
    void updateNoTries() {
        int number = 0;
        assertEquals(1, ++number);
    }

    @Test
    void getId() {
        player.setId("AlaMaKota");
        assertTrue(player.getId() == "AlaMaKota");
    }

    @Test
    void getNumberOfTries() {
        player.setNumberOfTries(5);
        assertTrue(player.getNumberOfTries() == 5);
    }

    @Test
    void getNumberToGuess() {
        player.setNumberToGuess(10);
        assertTrue(player.getNumberToGuess() == 10);
    }

    @Test
    void setId() {
        String someId = "AlaMaPsa";
        player.setId(someId);
        assertEquals(player.getId(), someId);
    }

    @Test
    void setNumberOfTries() {
        int no = 5;
        player.setNumberOfTries(no);
        assertEquals(no, player.getNumberOfTries());
    }

    @Test
    void setNumberToGuess() {
        int no = 10;
        player.setNumberToGuess(no);
        assertEquals(no, player.getNumberToGuess());
    }
}