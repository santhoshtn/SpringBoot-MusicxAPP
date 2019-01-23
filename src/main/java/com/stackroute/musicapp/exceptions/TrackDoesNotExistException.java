package com.stackroute.musicapp.exceptions;
//custom exception TrackDoesNotExistException class
public class TrackDoesNotExistException extends Exception {
    private String message;
    public TrackDoesNotExistException(String message){
        super(message);
    }
}
