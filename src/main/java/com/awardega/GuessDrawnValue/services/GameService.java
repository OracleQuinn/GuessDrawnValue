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
    List<Player> listOfWinners = playerRepository.getPlayerList();

    Game startGame = new Game();

    /**
     * The method checks if the player with the given ID already exists. Method for creating a new player.
     * @param player
     * @return newPlayer
     */
    public Player addNewPlayer(Player player){
        Player newPlayer = new Player();
        newPlayer.setId(player.getId());

        for (Player gamer : listOfPlayers) {
            if (newPlayer.getId().equals(gamer.getId())) {
                System.out.println("ERROR! This id is registered!");
                return null;
            }
        }

        listOfPlayers.add(newPlayer);
        return newPlayer;
    }

    /**
     * A method that returns a list of all players
     * @return listOfPlayers
     */
    public List<Player> getAllPlayers() {
        return listOfPlayers;
    }

    /**
     * Player return method
     * @param id
     * @return player
     */
    public Player getPlayer(String id) {
        return Optional.of(playerRepository.getPlayerList()
                        .stream()
                        .filter(player -> player.getId().equals(id))
                        .findFirst()
                        .get())
                .orElse(null);
    }

    /**
     * A method that returns information about the result of the round.
     * @param id
     * @param guessNumber
     * @return result
     */
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
            listOfWinners.add(player);
        }
        else {
            player.updateNoTries();
        }

        return result;
    }

    /**
     * A method to check if the player has guessed the number,
     * returning information as to whether the player succeeded, otherwise what went wrong.
     * @param secretNumber
     * @param guessNumber
     * @return message
     */
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


    /**
     * Method that returns a list of the 10 players with the fewest attempts.
     * @return listOfWinners
     */
    public List<Player> best10Players(){
        return listOfWinners.stream()
                .sorted(Comparator.comparingInt(Player::getNumberOfTries))
                .limit(10)
                .collect(Collectors.toList());
    }
}

