package com.example.parkshark.helperClasses;

public class NumericCheck {

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

}
