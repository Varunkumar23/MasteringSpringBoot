package com.capgemini.ECommerceOrderManagementSystem.exception;

import java.io.Serial;

public class ValidationException extends IllegalArgumentException {
	/**
	 * 
	 */
	@Serial
    private static final long serialVersionUID = 1L;

	public ValidationException(String message) {
		super(message);
	}

}
