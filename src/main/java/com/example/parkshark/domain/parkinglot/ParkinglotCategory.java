package com.example.parkshark.domain.parkinglot;

public enum ParkinglotCategory {
    UNDERGROUND("Underground"),
    ABOVEGROUND("Aboveground");

    private String type;

    ParkinglotCategory(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
