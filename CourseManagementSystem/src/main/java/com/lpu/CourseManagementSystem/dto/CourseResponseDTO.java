package com.lpu.CourseManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class CourseResponseDTO {
    private Long id;
    private String title;
    private String instructor;
    private Integer duration;
    private Double price;
    private LocalDateTime createdAt;
}
