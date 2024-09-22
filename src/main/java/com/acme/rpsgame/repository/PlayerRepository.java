package com.acme.rpsgame.repository;

import com.acme.rpsgame.model.Player;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

  Optional<Player> findByUsername(String username);
}
