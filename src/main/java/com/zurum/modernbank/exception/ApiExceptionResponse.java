package com.zurum.modernbank.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
public class ApiExceptionResponse {

    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime timeStamp;

}
