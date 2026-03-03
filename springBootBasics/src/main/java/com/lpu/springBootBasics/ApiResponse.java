package com.lpu.springBootBasics;

import java.time.LocalDate;

public class ApiResponse {
	private LocalDate timeStamp;
	private int status;
	private String error;
	private String message;
	private String path;

	public ApiResponse(int status, String error, String message, String path) {
		this.timeStamp = LocalDate.now();
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public LocalDate getTimeStamp() {
		return timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

}
