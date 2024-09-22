package com.acme.rpsgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RockPaperScissorsApplication {

  public static void main(String[] args) {
    SpringApplication.run(RockPaperScissorsApplication.class, args);
  }

}
