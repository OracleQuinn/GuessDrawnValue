package com.awardega.GuessDrawnValue.services;

import com.awardega.GuessDrawnValue.entities.Game;
import com.awardega.GuessDrawnValue.entities.Player;
import com.awardega.GuessDrawnValue.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl {
    PlayerRepository playerRepository  = new PlayerRepository();
    List<Player> listOfPlayers = playerRepository.getPlayerList();

    Game startGame = new Game();

    public Player addNewPlayer(Player player){
        Player newPlayer = new Player();
        newPlayer.setId(player.getId());

        for (Player gamer : listOfPlayers) {
            if (newPlayer.getId().equals(gamer.getId())) {
                System.out.println("You already exist in our game!");
                return null;
            }
        }

        listOfPlayers.add(newPlayer);
        return newPlayer;
    }

    public List<Player> get10BestPlayers(){
        return listOfPlayers.stream()
                .sorted(Comparator.comparingInt(Player::getNumberOfTries))
                .limit(10)
                .collect(Collectors.toList());
    }

    public Player getPlayer(String id) {
        return Optional.of(playerRepository.getPlayerList()
                        .stream()
                        .filter(player -> player.getId().equals(id))
                        .findFirst()
                        .get())
                .orElse(null);
    }

    public String startingGame(String id, int guessNumber){
        Player player = getPlayer(id);
        int secretNumber = 0;

        if (player.getNumberToGuess() == 0){
            secretNumber = startGame.getDrawvalue();
            player.setNumberToGuess(secretNumber);

            startGame = new Game();
        }
        else {
            secretNumber = player.getNumberToGuess();
        }

        String result = verifyGuess(player, secretNumber, guessNumber);

        return result;
    }

    public String verifyGuess(Player player, int secretNumber, int guessNumber) {
        String message = null;
        boolean gameResult;
        gameResult = startGame.guessedOrNot(secretNumber, guessNumber);
        if (gameResult == false) {
            if (guessNumber < secretNumber) message = "Too small 🙁 ";
            else message = "Too big 😐 ";
            player.updateNoTries();
        }
        else {
            message = "Congratulations! You win!";
        }

        return message;
    }
}

