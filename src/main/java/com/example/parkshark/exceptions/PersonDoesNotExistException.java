package com.example.parkshark.exceptions;

public class PersonDoesNotExistException extends RuntimeException {
    public PersonDoesNotExistException(String message) {
        super(message);
    }
}
