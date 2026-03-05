package com.lpu.springBootBasics.exception;

import com.lpu.springBootBasics.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//This annotation is Used to handle exceptions globally for REST APIs
//“Whenever any controller throws an exception, handle it here.”

@RestControllerAdvice
public class ApplicationException {

	public ResponseEntity<ApiResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex,
                                                                       HttpServletRequest request) {
		ApiResponse response = new ApiResponse(HttpStatus.NOT_FOUND.value(), "Employee Not Found", ex.getMessage(),
				request.getRequestURI());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}
}
