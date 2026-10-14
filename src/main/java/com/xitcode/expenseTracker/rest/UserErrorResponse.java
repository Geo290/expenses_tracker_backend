package com.xitcode.expenseTracker.rest;
import java.time.LocalDateTime;

public record UserErrorResponse(
        int status,
        String message,
        LocalDateTime timestamp
) {}
