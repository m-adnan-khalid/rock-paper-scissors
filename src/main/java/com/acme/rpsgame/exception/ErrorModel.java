package com.acme.rpsgame.exception;

public class ErrorModel {

  private String element;
  private String message;

  public ErrorModel(String message, String element) {
    this.message = message;
    this.element = element;
  }

  public String getElement() {
    return element;
  }

  public void setElement(String element) {
    this.element = element;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
