package com.acme.rpsgame.service;

import com.acme.rpsgame.model.GameStatistics;
import java.util.Optional;

public interface GameStatisticsService {

  GameStatistics getStatistics(String username);

  GameStatistics getStatisticsById(String id);

  GameStatistics save(GameStatistics gameStatistics);

}
