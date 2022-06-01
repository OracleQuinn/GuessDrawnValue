package com.awardega.GuessDrawnValue.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

@Data
@RequiredArgsConstructor
public class Game {
    Random random = new Random();

    private int drawvalue;
    private int guessvalue;

    public int drawFunction() {
        drawvalue = random.nextInt(100)+1;
        return drawvalue;
    }

    public boolean guessedOrNot(int drawvalue, int guessvalue){
        boolean result;

        if (drawvalue == guessvalue) result = true;
        else result = false;

        return result;
    }
}