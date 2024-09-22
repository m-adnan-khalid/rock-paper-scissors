package com.acme.rpsgame.repository;

import com.acme.rpsgame.model.GameStatistics;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameStatisticsRepository extends MongoRepository<GameStatistics, String> {

  Optional<GameStatistics> findByPlayerId(String playerId);

}
