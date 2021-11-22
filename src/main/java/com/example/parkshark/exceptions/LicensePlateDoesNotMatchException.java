package com.example.parkshark.exceptions;

public class LicensePlateDoesNotMatchException extends RuntimeException {

    public LicensePlateDoesNotMatchException(String message) {
        super(message);
    }
}
