package com.acme.rpsgame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MissingParameterException extends RuntimeException {

  public MissingParameterException(String parameterName) {
    super("Required request parameter '" + parameterName + "' is not present.");
  }

}
