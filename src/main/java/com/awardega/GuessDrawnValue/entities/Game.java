package com.awardega.GuessDrawnValue.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.Random;

@Data
@RequiredArgsConstructor
public class Game {
    Random random = new Random();

    private int drawvalue;
    private int guessvalue;

    /**
     * A method that randomizes a number to guess.
     * @return drawvalue
     */
    public int drawFunction() {
        drawvalue = random.nextInt(100)+1;
        return drawvalue;
    }

    /**
     * A method that checks if the value provided by the user (guessvalue) is less, greater, or equal to the value drawn (drawvalue).
     * @param drawvalue
     * @param guessvalue
     * @return result
     */
    public boolean guessedOrNot(int drawvalue, int guessvalue){
        boolean result;

        if (drawvalue == guessvalue) result = true;
        else result = false;

        return result;
    }
}