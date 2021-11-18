package com.example.parkshark.exceptions;

public class ParkinglotDoesNotExistException extends RuntimeException{

    public ParkinglotDoesNotExistException(String message) {
        super(message);
    }
}
