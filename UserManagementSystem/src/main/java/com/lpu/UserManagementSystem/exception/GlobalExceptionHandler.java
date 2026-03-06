package com.lpu.UserManagementSystem.exception;

import com.lpu.UserManagementSystem.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "User Not Found", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<ErrorResponse> handleDuplicateUserException(DuplicateUserException ex, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse(HttpStatus.CONTINUE.value(), "User Already Exists", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
