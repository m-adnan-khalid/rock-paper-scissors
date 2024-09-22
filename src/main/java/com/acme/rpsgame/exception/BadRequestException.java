package com.acme.rpsgame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

  String element;

  public BadRequestException(String message, String element) {
    super(message);
    this.element = element;
  }

  public String getElement() {
    return element;
  }
}
