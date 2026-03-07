package com.lpu.CourseManagementSystem.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ErrorResponse {
    private final LocalDate timeStamp;
    private final int status;
    private final String error;
    private final String message;
    private final String path;

    public ErrorResponse(int status, String error, String message, String path) {
        this.timeStamp = LocalDate.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
