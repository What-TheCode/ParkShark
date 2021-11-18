package com.example.parkshark.exceptions;

public class MemberDoesNotExistException extends RuntimeException{

    public MemberDoesNotExistException(String message) {
        super(message);
    }
}
