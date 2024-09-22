package com.acme.rpsgame.repository;

import com.acme.rpsgame.model.Move;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoveRepository extends MongoRepository<Move, String> {

}
