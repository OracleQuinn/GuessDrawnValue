package com.awardega.GuessDrawnValue.dao;

import com.awardega.GuessDrawnValue.models.RoundModel;
import java.util.List;

public interface IRoundDAO {
    RoundModel addRound(RoundModel round);
    List<RoundModel> getRoundsByGameId(int gameId);
    RoundModel getRoundById(int roundId);
}
