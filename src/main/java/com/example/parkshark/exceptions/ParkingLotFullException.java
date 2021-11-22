package com.example.parkshark.exceptions;

public class ParkingLotFullException extends RuntimeException {

    public ParkingLotFullException(String message) {
        super(message);
    }
}
