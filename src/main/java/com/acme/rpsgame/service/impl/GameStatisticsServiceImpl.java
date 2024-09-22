package com.acme.rpsgame.service.impl;

import static com.acme.rpsgame.constant.CacheKeys.GAME_STATS_CACHE;

import com.acme.rpsgame.exception.ResourceNotFoundException;
import com.acme.rpsgame.model.GameStatistics;
import com.acme.rpsgame.model.Player;
import com.acme.rpsgame.repository.GameStatisticsRepository;
import com.acme.rpsgame.service.GameStatisticsService;
import com.acme.rpsgame.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class GameStatisticsServiceImpl implements GameStatisticsService {

  private final GameStatisticsRepository gameStatisticsRepository;

  @Autowired
  private PlayerService playerService;

  public GameStatisticsServiceImpl(GameStatisticsRepository gameStatisticsRepository) {
    this.gameStatisticsRepository = gameStatisticsRepository;
  }

  @Override
  public GameStatistics getStatistics(String username) {
    Player player = playerService.getPlayerByUsername(username).orElseThrow(
        () -> new ResourceNotFoundException("Player not found with provided value:" + username,
            "username"));
    return gameStatisticsRepository.findByPlayerId(player.getId()).orElseThrow(
        () -> new ResourceNotFoundException("Stats not found with provided value:" + username,
            "username"));
  }

  @Override
  @Cacheable(unless = "#result == null", value = GAME_STATS_CACHE, key = "#playerId")
  public GameStatistics getStatisticsById(String playerId) {
    return gameStatisticsRepository.findByPlayerId(playerId).orElse(null);
  }

  @Override
  @CacheEvict(value = GAME_STATS_CACHE, key = "#gameStatistics.playerId")
  public GameStatistics save(GameStatistics gameStatistics) {
    return gameStatisticsRepository.save(gameStatistics);
  }
}
