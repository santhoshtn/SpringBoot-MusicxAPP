package com.stackroute.musicapp.exceptions;

public class UserAlreadyExistsException extends Exception {
    private String message;


    public UserAlreadyExistsException(String message){
        super(message);
    }
}
