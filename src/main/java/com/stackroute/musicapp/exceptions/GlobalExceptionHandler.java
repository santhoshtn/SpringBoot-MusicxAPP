package com.stackroute.musicapp.exceptions;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity userAlreadyExistsException(final UserAlreadyExistsException e) {
        return  new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
    }

    @ExceptionHandler(TrackDoesNotExistException.class)
    public ResponseEntity trackDoesNotExistException(final TrackDoesNotExistException e) {
        return  new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
    }
}
