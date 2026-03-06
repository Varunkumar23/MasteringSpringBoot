package com.lpu.springBootBasics.exception;

import com.lpu.springBootBasics.dto.ApiResponse;
import com.lpu.springBootBasics.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//This annotation is Used to handle exceptions globally for REST APIs
//Whenever any controller throws an exception, handle it here.

@RestControllerAdvice
public class ApplicationException {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex,HttpServletRequest request) {
		ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Employee Not Found", ex.getMessage(),
				request.getRequestURI());
		System.out.println("Exception handler triggered");
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}
}
