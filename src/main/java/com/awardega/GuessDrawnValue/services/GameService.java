package com.awardega.GuessDrawnValue.services;

import com.awardega.GuessDrawnValue.entities.Game;
import com.awardega.GuessDrawnValue.entities.Player;
import com.awardega.GuessDrawnValue.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GameService {
    PlayerRepository playerRepository  = new PlayerRepository();
    List<Player> listOfPlayers = playerRepository.getPlayerList();

    Game startGame = new Game();

    public Player addNewPlayer(Player player){
        Player newPlayer = new Player();
        newPlayer.setId(player.getId());

        for (Player gamer : listOfPlayers) {
            if (newPlayer.getId().equals(gamer.getId())) {
                System.out.println("ERROR! This id is registred!");
                return null;
            }
        }

        listOfPlayers.add(newPlayer);
        return newPlayer;
    }

    public List<Player> getAllPlayers() {
        return listOfPlayers;
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

        if (player.getNumberToGuess() == 0){
            int secretNumber = startGame.drawFunction();
            player.setNumberToGuess(secretNumber);

            startGame = new Game();
        }

        String result = verifyGuess(player.getNumberToGuess(), guessNumber);
        if(result == "Congratulations! You win!"){
            player.updateNoTries();
            player.setNumberToGuess(0);
        }
        else {
            player.updateNoTries();
        }

        return result;
    }

    public String verifyGuess(int secretNumber, int guessNumber){
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

    public List<Player> best10Players(){
        return listOfPlayers.stream()
                .sorted(Comparator.comparingInt(Player::getNumberOfTries))
                .limit(10)
                .collect(Collectors.toList());
    }
}

