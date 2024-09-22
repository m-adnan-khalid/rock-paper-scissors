package com.acme.rpsgame.constant;

public class ApiPaths {

  public static final String BASE_API = "/api/v1";
  public static final String PLAYERS = BASE_API + "/players";
  public static final String PLAYER_STATS = PLAYERS + "/{username}/stats";
  public static final String START_GAME = PLAYERS + "/start";
  public static final String MAKE_MOVE = PLAYERS + "/{gameId}/move";
  public static final String TERMINATE_GAME = PLAYERS + "/{gameId}/terminate";
  public static final String GET_GAME = PLAYERS + "/{gameId}";

}
