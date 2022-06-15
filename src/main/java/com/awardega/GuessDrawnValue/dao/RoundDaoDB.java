package com.awardega.GuessDrawnValue.dao;

import com.awardega.GuessDrawnValue.models.RoundModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class RoundDaoDB implements IRoundDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    public RoundDaoDB(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public RoundModel addRound(RoundModel roundModel) {
        final String sql = "INSERT INTO guessNumberRound(game_id, guess, result) VALUES(?,?,?)";
        jdbcTemplate.update(sql, roundModel.getRoundId(), roundModel.getGuess(), roundModel.getResult());

        int newRoundId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        roundModel.setRoundId(newRoundId);

        return getRoundById(newRoundId);
    }

    @Override
    public List<RoundModel> getRoundsByGameId(int gameId) {
        try {
            final String sql = "SELECT * FROM guessNumberRound "
                    + "WHERE game_id = ? ORDER BY timeOfGuess";
            List<RoundModel> rounds = jdbcTemplate.query(sql, new RoundMapper(), gameId);
            return rounds;
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    public RoundModel getRoundById(int roundId) {
        return null;
    }

    public static final class RoundMapper implements RowMapper<RoundModel> {

        @Override
        public RoundModel mapRow(ResultSet rs, int index) throws SQLException {
            RoundModel roundModel = new RoundModel();
            roundModel.setRoundId(rs.getInt("id"));
            roundModel.setGameId(rs.getInt("game_id"));
            roundModel.setGuess(rs.getString("guess"));

            Timestamp timestamp = rs.getTimestamp("timeOfGuess");
            roundModel.setTime(timestamp.toLocalDateTime());

            roundModel.setResult(rs.getString("result"));

            return roundModel;
        }
    }
}
