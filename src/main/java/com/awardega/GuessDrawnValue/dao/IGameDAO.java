package com.awardega.GuessDrawnValue.dao;

import com.awardega.GuessDrawnValue.models.GameModel;

import java.util.List;

public interface IGameDAO {
    GameModel addGame(GameModel gameModel);
    GameModel getGame(int game);
    List<GameModel> getAllGames();
    void updateGame(GameModel round);
}
