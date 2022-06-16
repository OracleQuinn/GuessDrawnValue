package com.awardega.GuessDrawnValue.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class Player {
    private String id;
    private int numberOfTries = 0;
    private int numberToGuess = 0;

    /**
     * A method for increasing the number of player attempts.
     */
    public void updateNoTries(){
        numberOfTries++;
    }
}
