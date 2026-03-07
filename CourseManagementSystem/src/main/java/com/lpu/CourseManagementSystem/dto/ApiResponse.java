package com.lpu.CourseManagementSystem.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiResponse <T>{
    private boolean success;
    private String message;
    private T data;

}
