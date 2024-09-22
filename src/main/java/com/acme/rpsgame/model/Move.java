package com.acme.rpsgame.model;

import static com.acme.rpsgame.constant.MongoCollections.MOVES;

import com.acme.rpsgame.enums.GameMove;
import com.acme.rpsgame.enums.GameResult;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = MOVES)
public class Move {
  @Id
  private String id;
  private String gameId;
  private GameMove playerMove;
  private GameMove systemMove;
  private GameResult gameResult;
  private Date timestamp;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getGameId() {
    return gameId;
  }

  public void setGameId(String gameId) {
    this.gameId = gameId;
  }

  public GameMove getPlayerMove() {
    return playerMove;
  }

  public void setPlayerMove(GameMove playerMove) {
    this.playerMove = playerMove;
  }

  public GameMove getSystemMove() {
    return systemMove;
  }

  public void setSystemMove(GameMove systemMove) {
    this.systemMove = systemMove;
  }

  public GameResult getResult() {
    return gameResult;
  }

  public void setResult(GameResult gameResult) {
    this.gameResult = gameResult;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }
}
