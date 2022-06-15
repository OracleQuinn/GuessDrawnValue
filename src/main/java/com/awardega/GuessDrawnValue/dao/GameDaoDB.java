package com.awardega.GuessDrawnValue.dao;

import com.awardega.GuessDrawnValue.models.GameModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDaoDB implements IGameDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public GameModel addGame(GameModel gameModel){
        String sqlQuery = "INSERT INTO guessNumber(targetNumber) VALUES (?)";

        jdbcTemplate.update(sqlQuery, gameModel.getTarget());

        int newGameId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        gameModel.setGameId(newGameId);

        return gameModel;
    }

    @Override
    public GameModel getGame(int gameModel){
        final String sqlQuery = "SELECT id, targetNumber, finished "
                + "FROM guessNumber WHERE id = ?;";

        return jdbcTemplate.queryForObject(sqlQuery, new GameMapper(), gameModel);
    }

    @Override
    public List<GameModel> getAllGames() {

        final String sqlQuery = "SELECT id, targetNumber, finished FROM guessNumber;";

        return jdbcTemplate.query(sqlQuery, new GameMapper());


    }

    @Override
    public void updateGame(GameModel gameModel) {

        final String sqlQuery = "UPDATE guessNumber SET "
                + "finished = ? "
                + "WHERE id = ?;";

        jdbcTemplate.update(sqlQuery, gameModel.isFinished(), gameModel.getGameId());

    }

    public static final class GameMapper implements RowMapper<GameModel> {

        @Override
        public GameModel mapRow(ResultSet rs, int index) throws SQLException {
            GameModel gameModel = new GameModel();
            gameModel.setGameId(rs.getInt("id"));
            gameModel.setTarget(rs.getString("targetNumber"));
            gameModel.setFinished(rs.getBoolean("finished"));
            return gameModel;
        }
    }
}
