package com.acme.rpsgame.model;

import static com.acme.rpsgame.constant.MongoCollections.GAME_STATISTICS;

import com.acme.rpsgame.enums.GameResult;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = GAME_STATISTICS)
public class GameStatistics implements Serializable {

  private static final long serialVersionUID = -6665231507921405350L;
  @Id
  private String id;
  private String playerId;
  private int totalGames;
  private int totalWins;
  private int totalLosses;
  private int totalDraws;
  private double winRate;

  public void updateStats(GameResult gameResult) {
    this.totalGames++;
    switch (gameResult) {
      case WIN -> this.totalWins++;
      case LOSE -> this.totalLosses++;
      case DRAW -> this.totalDraws++;
    }
    this.winRate = (double) this.totalWins / this.totalGames;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPlayerId() {
    return playerId;
  }

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }

  public int getTotalGames() {
    return totalGames;
  }

  public void setTotalGames(int totalGames) {
    this.totalGames = totalGames;
  }

  public int getTotalWins() {
    return totalWins;
  }

  public void setTotalWins(int totalWins) {
    this.totalWins = totalWins;
  }

  public int getTotalLosses() {
    return totalLosses;
  }

  public void setTotalLosses(int totalLosses) {
    this.totalLosses = totalLosses;
  }

  public int getTotalDraws() {
    return totalDraws;
  }

  public void setTotalDraws(int totalDraws) {
    this.totalDraws = totalDraws;
  }

  public double getWinRate() {
    return winRate;
  }

  public void setWinRate(double winRate) {
    this.winRate = winRate;
  }
}
