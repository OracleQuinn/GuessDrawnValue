package com.awardega.GuessDrawnValue.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class RoundModel {
    public  int gameId;
    public  int roundId;
    public LocalDateTime time;
    public String guess;
    public String result;

    public  RoundModel(int gameId, String guess){
        this.gameId = gameId;
        this.guess = guess;
    }

    public  RoundModel(int gameId, int roundId, LocalDateTime time, String guess, String result){
        this.gameId = gameId;
        this.roundId = roundId;
        this.time = time;
        this.guess = guess;
        this.result = result;
    }
}
