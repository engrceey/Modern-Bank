package com.zurum.modernbank.exception;

public class ApiRequestException extends RuntimeException{

    public ApiRequestException(String message) {
        super(message);
    }
}
