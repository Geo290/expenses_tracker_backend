package com.xitcode.expenseTracker.exception.responses;
import java.time.LocalDateTime;

public record ExceptionResponse(
  	int status,
    String message,
    LocalDateTime timestamp
) {}
