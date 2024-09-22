package com.acme.rpsgame.service.impl;

import com.acme.rpsgame.enums.GameMove;
import com.acme.rpsgame.enums.GameResult;
import com.acme.rpsgame.model.Move;
import com.acme.rpsgame.repository.MoveRepository;
import com.acme.rpsgame.service.MoveService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveServiceImpl implements MoveService {

  @Autowired
  private MoveRepository moveRepository;

  @Override
  public Move makeMove(String gameId, Move move) {
    move.setGameId(gameId);
    move.setTimestamp(new Date());
    move.setSystemMove(GameMove.getSystemMove());
    move.setResult(determineResult(move.getPlayerMove(), move.getSystemMove()));
    return moveRepository.save(move);
  }

  GameResult determineResult(GameMove playerMove, GameMove systemMove) {
    if (playerMove == systemMove) {
      return GameResult.DRAW;
    } else if (playerMove.beats(systemMove)) {
      return GameResult.WIN;
    } else {
      return GameResult.LOSE;
    }
  }
}
