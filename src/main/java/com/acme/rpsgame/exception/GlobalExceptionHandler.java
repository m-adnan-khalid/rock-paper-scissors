package com.acme.rpsgame.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ResponseEntity<String> handleMissingParameter(MissingParameterException ex) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(ex.getMessage());
  }

  @ExceptionHandler(value = ResourceNotFoundException.class)
  @ResponseStatus(NOT_FOUND)
  public ResponseEntity<Object> handleException(ResourceNotFoundException ex) {
    return createErrorResponse(NOT_FOUND, ex.getMessage(), ex.getElement());
  }

  @ExceptionHandler(value = BadRequestException.class)
  @ResponseStatus(BAD_REQUEST)
  public ResponseEntity<Object> handleException(BadRequestException ex) {
    return createErrorResponse(BAD_REQUEST, ex.getMessage(), ex.getElement());
  }

  @ExceptionHandler(value = ConflictRequestException.class)
  @ResponseStatus(CONFLICT)
  public ResponseEntity<Object> handleException(ConflictRequestException ex) {
    return createErrorResponse(CONFLICT, ex.getMessage(), ex.getElement());
  }

  ResponseEntity<Object> createErrorResponse(
      HttpStatus httpStatus, String message, String element
  ) {
    ErrorModel errorModel = new ErrorModel(message, element);
    return new ResponseEntity<>(errorModel, new HttpHeaders(), httpStatus);
  }

}
