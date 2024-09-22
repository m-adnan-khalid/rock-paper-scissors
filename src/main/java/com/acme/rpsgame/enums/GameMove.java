package com.acme.rpsgame.enums;

import com.acme.rpsgame.exception.BadRequestException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum GameMove {
  ROCK, PAPER, SCISSORS;
  private static final String ROCK_MOVE = "rock";
  private static final String PAPER_MOVE = "paper";
  private static final String SCISSORS_MOVE = "scissors";

  private static final List<String> possibleMoves = List.of(ROCK_MOVE, PAPER_MOVE, SCISSORS_MOVE);
  private static final Random RANDOM = new Random();

  public static GameMove fromString(String move) {
    return switch (move.toLowerCase()) {
      case ROCK_MOVE -> ROCK;
      case PAPER_MOVE -> PAPER;
      case SCISSORS_MOVE -> SCISSORS;
      default -> throw new BadRequestException("Please provide the valid Moves:  " + possibleMoves,
          "playerMove");
    };
  }

  public boolean beats(GameMove other) {
    return (this == ROCK && other == SCISSORS)
        || (this == PAPER && other == ROCK)
        || (this == SCISSORS && other == PAPER);
  }

  public static GameMove getSystemMove() {
    return values()[RANDOM.nextInt(values().length)];
  }
}
