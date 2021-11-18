package com.example.parkshark.domain.member;

public enum Membership {
    BRONZE("Bronze"),
    SILVER("Silver"),
    GOLD("Gold");

    private String value;

    Membership(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
