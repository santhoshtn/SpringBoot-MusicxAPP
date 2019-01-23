package com.stackroute.musicapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//provides global exception handling
@ControllerAdvice
public class GlobalExceptionHandler {

    //use to map UserAlreadyExistsException exception raised by controller methods
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity userAlreadyExistsException(final UserAlreadyExistsException e) {
        return  new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
    }
    //use to map TrackDoesNotExistException exception raised by controller methods
    @ExceptionHandler(TrackDoesNotExistException.class)
    public ResponseEntity trackDoesNotExistException(final TrackDoesNotExistException e) {
        return  new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
    }
}
