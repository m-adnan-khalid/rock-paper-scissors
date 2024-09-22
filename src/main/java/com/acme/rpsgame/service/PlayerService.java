package com.acme.rpsgame.service;

import com.acme.rpsgame.model.Player;
import java.util.Optional;

public interface PlayerService {

  Player createPlayer(String username, String email);

  Optional<Player> getPlayerByUsername(String username);
}
