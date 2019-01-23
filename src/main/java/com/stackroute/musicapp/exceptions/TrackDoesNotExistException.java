package com.stackroute.musicapp.exceptions;

public class TrackDoesNotExistException extends Exception {
    private String message;
    public TrackDoesNotExistException(String message){
        super(message);
    }
}
