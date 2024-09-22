package com.acme.rpsgame.service.impl;

import static java.util.Objects.isNull;

import com.acme.rpsgame.enums.GameMove;
import com.acme.rpsgame.enums.GameStatus;
import com.acme.rpsgame.exception.BadRequestException;
import com.acme.rpsgame.exception.ResourceNotFoundException;
import com.acme.rpsgame.model.Game;
import com.acme.rpsgame.model.GameStatistics;
import com.acme.rpsgame.model.Move;
import com.acme.rpsgame.model.Player;
import com.acme.rpsgame.repository.GameRepository;
import com.acme.rpsgame.service.GameService;
import com.acme.rpsgame.service.GameStatisticsService;
import com.acme.rpsgame.service.MoveService;
import com.acme.rpsgame.service.PlayerService;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

  private final GameRepository gameRepository;

  private final MoveService moveService;

  private final GameStatisticsService statisticsService;

  private final PlayerService playerService;

  public GameServiceImpl(GameRepository gameRepository, MoveService moveService,
      GameStatisticsService statisticsService, PlayerService playerService) {
    this.gameRepository = gameRepository;
    this.moveService = moveService;
    this.statisticsService = statisticsService;
    this.playerService = playerService;
  }

  @Override
  public Game startGame(String username) {
    Player player = playerService.getPlayerByUsername(username).orElseThrow(
        () -> new ResourceNotFoundException("Player not found with provided value:" + username,
            "username"));
    Game game = new Game();
    game.setPlayerId(player.getId());
    game.setStartTime(new Date());
    game.setStatus(GameStatus.ACTIVE);
    return gameRepository.save(game);
  }

  @Override
  public Move makeMove(String gameId, GameMove gameMove) {
    Game game = getGame(gameId);
    Move move = new Move();
    move.setPlayerMove(gameMove);
    if (game.getStatus() != GameStatus.ACTIVE) {
      throw new BadRequestException("Game is Not Active with provided value: " + gameId, "gameId");
    }
    moveService.makeMove(gameId, move);
    updateStates(game, move);
    return move;
  }

  @Override
  public Game terminateGame(String gameId) {
    Game game = getGame(gameId);
    game.setStatus(GameStatus.TERMINATED);
    return gameRepository.save(game);
  }

  @Override
  public Game getGame(String gameId) {
    return gameRepository.findById(gameId)
        .orElseThrow(
            () -> new ResourceNotFoundException("Game not found with provided value:" + gameId,
                "gameId"));

  }

  void updateStates(Game game, Move move) {
    GameStatistics gameStatistics = statisticsService.getStatisticsById(game.getPlayerId());
    if (isNull(gameStatistics)) {
      gameStatistics = new GameStatistics();
      gameStatistics.setPlayerId(game.getPlayerId());
    }
    gameStatistics.updateStats(move.getResult());
    game.setPlayerScore(gameStatistics.getTotalWins());
    game.setSystemScore(gameStatistics.getTotalLosses());
    gameRepository.save(game);
    statisticsService.save(gameStatistics);
  }
}
