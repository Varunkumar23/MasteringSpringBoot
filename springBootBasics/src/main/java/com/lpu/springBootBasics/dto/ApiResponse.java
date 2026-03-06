package com.lpu.springBootBasics.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString


public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;
}
