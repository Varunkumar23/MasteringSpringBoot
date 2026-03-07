package com.lpu.CourseManagementSystem.service;

import com.lpu.CourseManagementSystem.dto.CourseRequestDTO;
import com.lpu.CourseManagementSystem.dto.CourseResponseDTO;
import org.springframework.data.domain.Page;

public interface CourseService {

    CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO);

    CourseResponseDTO getCourseById(Long id);

    Page<CourseResponseDTO> getAllCourses(int page, int size, String sortBy);

    CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO);

    void deleteCourse(Long id);
}
