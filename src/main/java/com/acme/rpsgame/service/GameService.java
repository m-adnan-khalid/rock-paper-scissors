package com.acme.rpsgame.service;

import com.acme.rpsgame.enums.GameMove;
import com.acme.rpsgame.model.Game;
import com.acme.rpsgame.model.Move;

public interface GameService {

  Game startGame(String username);

  Move makeMove(String gameId, GameMove gameMove);

  Game terminateGame(String gameId);

  Game getGame(String gameId);
}
