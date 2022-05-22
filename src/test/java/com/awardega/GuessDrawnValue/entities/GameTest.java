package com.awardega.GuessDrawnValue.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;

    @BeforeEach
    void setUp() {
        System.out.println("Set up");
        game = new Game();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tear down");
    }


    @Test
    void shouldReturnIsNotNull() {
        assertNotNull(game.drawFunction());
    }

    @Test
    void getDrawvalue() {
        game.setDrawvalue(2);
        assertTrue(game.getDrawvalue() == 2);
    }

    @Test
    void setDrawvalue() {
        int draValue = 2;
        game.setDrawvalue(draValue);
        assertEquals(game.getDrawvalue(), draValue);
    }

    @Test
    void getGuessvalue() {
        game.setGuessvalue(2);
        assertTrue(game.getGuessvalue() == 2);
    }

    @Test
    void setGuessvalue() {
        int guessValue = 2;
        game.setGuessvalue(guessValue);
        assertEquals(game.getGuessvalue(), guessValue);
    }

    @Test
    void drawFunction() {
        int drawValue = game.drawFunction();
        assertEquals(drawValue, game.getDrawvalue());
    }

    @Test
    void getValueFunction() {
        PrintStream output = new PrintStream(System.out);
        String input = "101\n"
                + "10\n";

        assertEquals(10, game.getValueFunction(new Scanner(input), new PrintStream(output)));
    }

    @Test
    void guessedOrNot_shouldReturnFalse() {
        assertEquals(false, game.guessedOrNot(3,5));
    }

    @Test
    void guessedOrNot_shouldReturnTrue() {
        assertEquals(true, game.guessedOrNot(66,66));
    }
}