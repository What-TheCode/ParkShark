package com.example.parkshark.exceptions;

public class MemberAlreadyExistException extends RuntimeException {

    public MemberAlreadyExistException(String message) {
        super(message);
    }
}
