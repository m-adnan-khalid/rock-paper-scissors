package com.acme.rpsgame.validator;

import static io.micrometer.common.util.StringUtils.isBlank;

import com.acme.rpsgame.exception.ConflictRequestException;
import com.acme.rpsgame.exception.MissingParameterException;
import com.acme.rpsgame.model.Player;
import com.acme.rpsgame.service.PlayerService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PlayerValidator implements Validator {

  private final PlayerService playerService;

  public PlayerValidator(PlayerService playerService) {
    this.playerService = playerService;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return Player.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {

  }

  @Override
  public Errors validateObject(Object target) {
    Player player = (Player) target;
    if (isBlank(player.getUsername())) {
      throw new MissingParameterException("username");
    }
    if (isBlank(player.getEmail())) {
      throw new MissingParameterException("email");
    }
    boolean isAlreadyExist = playerService.getPlayerByUsername(
        player.getUsername()).isPresent();
    if (isAlreadyExist) {
      throw new ConflictRequestException(
          "User already exist with the provided username: " + player.getUsername(), "username");
    }
    return null;
  }
}
