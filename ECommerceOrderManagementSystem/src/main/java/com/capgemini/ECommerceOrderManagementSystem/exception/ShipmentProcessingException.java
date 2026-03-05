package com.capgemini.ECommerceOrderManagementSystem.exception;

import java.io.Serial;

public class ShipmentProcessingException extends RuntimeException {
	/**
	 * 
	 */
	@Serial
    private static final long serialVersionUID = 1L;

	public ShipmentProcessingException(String message) {
		super(message);
	}

}
