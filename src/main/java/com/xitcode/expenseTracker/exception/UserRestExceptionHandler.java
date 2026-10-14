package com.xitcode.expenseTracker.exception;

import com.xitcode.expenseTracker.exception.exceptions.NoDataFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.xitcode.expenseTracker.exception.responses.*;
import java.time.LocalDateTime;

@RestControllerAdvice
public class UserRestExceptionHandler {

	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ExceptionResponse> handleBadCredentials(BadCredentialsException ex) {
		ExceptionResponse exResp = new ExceptionResponse(
				HttpStatus.UNAUTHORIZED.value(),
				ex.getMessage(),
				LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exResp);
	}

	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<ExceptionResponse> handleNotDateFound(NoDataFoundException ex) {
		ExceptionResponse exResp = new ExceptionResponse(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),
				LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exResp);
	}
}
