package com.acme.rpsgame.service;

import com.acme.rpsgame.model.Move;

public interface MoveService {

  Move makeMove(String gameId, Move move);
}
