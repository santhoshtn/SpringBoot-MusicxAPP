package com.stackroute.musicapp.exceptions;
//custom exception UserAlreadyExistsException class
public class UserAlreadyExistsException extends Exception {
    private String message;

    public UserAlreadyExistsException(String message){
        super(message);
    }
}
