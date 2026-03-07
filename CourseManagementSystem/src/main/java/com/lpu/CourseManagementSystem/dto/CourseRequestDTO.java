package com.lpu.CourseManagementSystem.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CourseRequestDTO {
    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotBlank(message = "Instructor name is required")
    private String instructor;

    @Min(1)
    private Integer duration;

    @PositiveOrZero
    private Double price;
}
