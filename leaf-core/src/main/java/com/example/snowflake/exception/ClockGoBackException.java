package com.example.snowflake.exception;

public class ClockGoBackException extends RuntimeException {
    public ClockGoBackException(String message) {
        super(message);
    }
}
