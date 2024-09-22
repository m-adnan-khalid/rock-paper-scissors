package com.acme.rpsgame.model;

import static com.acme.rpsgame.constant.MongoCollections.PLAYERS;

import java.io.Serializable;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = PLAYERS)
public class Player implements Serializable {

  private static final long serialVersionUID = 7900264870178737281L;
  @Id
  private String id;
  @Indexed(unique = true)
  private String username;
  private String email;
  private Date createdAt;
  private Date updatedAt;

  public Player() {

  }

  public Player(String username, String email) {
    this.username = username;
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
}
