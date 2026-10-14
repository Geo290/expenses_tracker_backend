package com.xitcode.expenseTracker.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class UserRestExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<UserErrorResponse> handleBadCredentials(
            BadCredentialsException e) {

        UserErrorResponse error = new UserErrorResponse(
                HttpStatus.UNAUTHORIZED.value(),
                e.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(error);
    }
}
