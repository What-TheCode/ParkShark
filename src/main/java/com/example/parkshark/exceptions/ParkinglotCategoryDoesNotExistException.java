package com.example.parkshark.exceptions;

public class ParkinglotCategoryDoesNotExistException extends RuntimeException {

    public ParkinglotCategoryDoesNotExistException(String message) {
        super(message);
    }
}
