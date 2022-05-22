package com.awardega.GuessDrawnValue.services;

import com.awardega.GuessDrawnValue.entities.Player;
import com.awardega.GuessDrawnValue.entities.Game;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl {
    public String verifyGuess(int secretNumber, int guessNumber) { //Player player
        //player.setNumberOfTries(player.getNumberOfTries()+1);

        Game startGame = new Game();
        String message = null;
        boolean gameResult;

        gameResult = startGame.guessedOrNot(secretNumber, guessNumber);
        if (gameResult == false) {
            if (guessNumber < secretNumber) message = "Too small 🙁 ";
            else message = "Too big 😐 ";
        }
        else {
            message = "Congratulations! You win!";
        }

        return message;
    }
}

