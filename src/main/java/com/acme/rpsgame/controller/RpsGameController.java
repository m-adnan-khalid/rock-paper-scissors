package com.acme.rpsgame.controller;

import static com.acme.rpsgame.constant.ApiPaths.GET_GAME;
import static com.acme.rpsgame.constant.ApiPaths.MAKE_MOVE;
import static com.acme.rpsgame.constant.ApiPaths.PLAYERS;
import static com.acme.rpsgame.constant.ApiPaths.PLAYER_STATS;
import static com.acme.rpsgame.constant.ApiPaths.START_GAME;
import static com.acme.rpsgame.constant.ApiPaths.TERMINATE_GAME;

import com.acme.rpsgame.enums.GameMove;
import com.acme.rpsgame.model.Game;
import com.acme.rpsgame.model.GameStatistics;
import com.acme.rpsgame.model.Move;
import com.acme.rpsgame.model.Player;
import com.acme.rpsgame.service.GameService;
import com.acme.rpsgame.service.GameStatisticsService;
import com.acme.rpsgame.service.PlayerService;
import com.acme.rpsgame.validator.PlayerValidator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RpsGameController {

  private final GameService gameService;

  private final PlayerService playerService;

  private final GameStatisticsService gameStatisticsService;

  private final PlayerValidator playerValidator;

  @InitBinder
  protected void initBinder(WebDataBinder binder) {
    binder.addValidators(playerValidator);
  }

  public RpsGameController(GameService gameService, PlayerService playerService,
      GameStatisticsService gameStatisticsService, PlayerValidator playerValidator) {
    this.gameService = gameService;
    this.playerService = playerService;
    this.gameStatisticsService = gameStatisticsService;
    this.playerValidator = playerValidator;
  }

  @PostMapping(PLAYERS)
  public Player createPlayer(@RequestParam String username, @RequestParam String email) {
    playerValidator.validateObject(new Player(username, email));
    return playerService.createPlayer(username, email);
  }

  @PostMapping(START_GAME)
  public Game startGame(@RequestParam String username) {
    return gameService.startGame(username);
  }

  @PostMapping(MAKE_MOVE)
  public Move makeMove(@PathVariable String gameId, @RequestParam String playerMove) {
    return gameService.makeMove(gameId, GameMove.fromString(playerMove));
  }

  @PostMapping(TERMINATE_GAME)
  public Game terminateGame(@PathVariable String gameId) {
    return gameService.terminateGame(gameId);
  }

  @GetMapping(GET_GAME)
  public Game getGame(@PathVariable String gameId) {
    return gameService.getGame(gameId);
  }

  @GetMapping(PLAYER_STATS)
  public GameStatistics getPlayerStatistics(@PathVariable String username) {
    return gameStatisticsService.getStatistics(username);
  }

}
