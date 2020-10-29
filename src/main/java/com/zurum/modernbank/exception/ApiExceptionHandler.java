package com.zurum.modernbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZoneId;
import java.time.ZonedDateTime;


@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<ApiExceptionResponse> handleApiRequestException(ApiRequestException aex) {
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse();
        apiExceptionResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        apiExceptionResponse.setTimeStamp(ZonedDateTime.now(ZoneId.of("Z")));
        apiExceptionResponse.setMessage(aex.getMessage());
        return new ResponseEntity<>(apiExceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
   @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ApiExceptionResponse> handleUserNotFound(UserNotFoundException unf) {
        ApiExceptionResponse response = new ApiExceptionResponse();
                response.setHttpStatus(HttpStatus.NOT_FOUND);
                response.setTimeStamp(ZonedDateTime.now(ZoneId.of("Z")));
                response.setMessage(unf.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiExceptionResponse> handleBadRequestException(Exception aex) {
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse();
        apiExceptionResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        apiExceptionResponse.setTimeStamp(ZonedDateTime.now(ZoneId.of("Z")));
        apiExceptionResponse.setMessage(aex.getMessage());
        return new ResponseEntity<>(apiExceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
