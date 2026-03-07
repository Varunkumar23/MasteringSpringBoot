package com.lpu.CourseManagementSystem.controller;


import com.lpu.CourseManagementSystem.dto.ApiResponse;
import com.lpu.CourseManagementSystem.dto.CourseRequestDTO;
import com.lpu.CourseManagementSystem.dto.CourseResponseDTO;
import com.lpu.CourseManagementSystem.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/courses")
@RestController
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<ApiResponse<CourseResponseDTO>> createCourse(@Valid @RequestBody CourseRequestDTO courseRequestDTO) {
        CourseResponseDTO response = courseService.createCourse(courseRequestDTO);
        ApiResponse<CourseResponseDTO> apiResponse = new ApiResponse<>(true, "Course Created Successfully!", response);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponseDTO>> getCourseById(@PathVariable Long id) {
        CourseResponseDTO response = courseService.getCourseById(id);
        ApiResponse<CourseResponseDTO> apiResponse = new ApiResponse<>(true, "Course Successfully Found With Id: " + id, response);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);


    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponseDTO>> updateCourse(@PathVariable Long id, @RequestBody CourseRequestDTO courseRequestDTO) {
        CourseResponseDTO response = courseService.updateCourse(id, courseRequestDTO);
        ApiResponse<CourseResponseDTO> apiResponse = new ApiResponse<>(true, "Course Successfully Updated With Id: " + id, response);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);


    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<CourseResponseDTO>>> getAllCourses(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "0") int size, @RequestParam(defaultValue = "id") String sortBy) {

        Page<CourseResponseDTO> courses = courseService.getAllCourses(page, size, sortBy);
        ApiResponse<Page<CourseResponseDTO>> response =
                new ApiResponse<>(true, "Courses fetched successfully", courses);

        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        ApiResponse<CourseResponseDTO> apiResponse = new ApiResponse<>(true, "Course Successfully Deleted With Id: " + id, null);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);


    }


}
