package com.acme.rpsgame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

  private String element;

  public ResourceNotFoundException(String message, String element) {
    super(message);
    this.element = element;
  }

  public String getElement() {
    return element;
  }
}
