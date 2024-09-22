package com.acme.rpsgame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictRequestException extends RuntimeException {

  String element;

  public ConflictRequestException(String message, String element) {
    super(message);
    this.element = element;
  }

  public String getElement() {
    return element;
  }
}
