package com.acme.rpsgame.model;

import static com.acme.rpsgame.constant.MongoCollections.GAMES;

import com.acme.rpsgame.enums.GameStatus;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = GAMES)
public class Game {

  @Id
  private String id;
  private String playerId;
  private Date startTime;
  private Date endTime;
  private GameStatus status;
  private int playerScore;
  private int systemScore;

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

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public GameStatus getStatus() {
    return status;
  }

  public void setStatus(GameStatus status) {
    this.status = status;
  }

  public int getPlayerScore() {
    return playerScore;
  }

  public void setPlayerScore(int playerScore) {
    this.playerScore = playerScore;
  }

  public int getSystemScore() {
    return systemScore;
  }

  public void setSystemScore(int systemScore) {
    this.systemScore = systemScore;
  }
}
