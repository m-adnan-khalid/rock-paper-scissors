package com.acme.rpsgame.service.impl;

import static com.acme.rpsgame.constant.CacheKeys.GAME_PLAYER_CACHE;

import com.acme.rpsgame.model.Player;
import com.acme.rpsgame.repository.PlayerRepository;
import com.acme.rpsgame.service.PlayerService;
import java.util.Date;
import java.util.Optional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

  private final PlayerRepository playerRepository;

  public PlayerServiceImpl(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

  @Override
  public Player createPlayer(String username, String email) {
    Player player = new Player();
    player.setEmail(email);
    player.setUsername(username);
    player.setCreatedAt(new Date());
    player.setUpdatedAt(new Date());
    return playerRepository.save(player);
  }

  @Override
  @Cacheable(unless = "#result == null", value = GAME_PLAYER_CACHE, key = "#username")
  public Optional<Player> getPlayerByUsername(String username) {
    return playerRepository.findByUsername(username);
  }
}
