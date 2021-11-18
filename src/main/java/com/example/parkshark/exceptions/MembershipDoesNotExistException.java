package com.example.parkshark.exceptions;

public class MembershipDoesNotExistException extends RuntimeException{

    public MembershipDoesNotExistException(String message) {
        super(message);
    }
}
