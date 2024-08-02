package org.gokapture.blogapi.controllers;

import org.gokapture.blogapi.exception.UserAlreadyExistsException;
import org.gokapture.blogapi.exception.UserDoesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExists(UserAlreadyExistsException ex) {
        return new ResponseEntity<>("A User Already Exist Exception: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserDoesNotFoundException.class)
    public ResponseEntity<String> handleUserDoesNotFound(UserDoesNotFoundException ex) {
        return new ResponseEntity<>("A User Does Not Exist Exception: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
