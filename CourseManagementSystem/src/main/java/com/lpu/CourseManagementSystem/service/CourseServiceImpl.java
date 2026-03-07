package com.lpu.CourseManagementSystem.service;

import com.lpu.CourseManagementSystem.dto.CourseRequestDTO;
import com.lpu.CourseManagementSystem.dto.CourseResponseDTO;
import com.lpu.CourseManagementSystem.entity.Course;
import com.lpu.CourseManagementSystem.exception.ResourceNotFoundException;
import com.lpu.CourseManagementSystem.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO) {
        Course course = modelMapper.map(courseRequestDTO, Course.class);
        Course saved = courseRepository.save(course);
        return modelMapper.map(saved, CourseResponseDTO.class);
    }

    @Override
    public CourseResponseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Course Found With Id: " + id));
        return modelMapper.map(course, CourseResponseDTO.class);

    }

    @Override
    public Page<CourseResponseDTO> getAllCourses(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Course> coursePage = courseRepository.findAll(pageable);
        return coursePage.map(course -> modelMapper.map(course, CourseResponseDTO.class));
    }

    @Override
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO) {
        Course existingCourse = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Course Found With Id: " + id));
        if (courseRequestDTO.getTitle() != null) {
            existingCourse.setTitle(courseRequestDTO.getTitle());
        }

        if (courseRequestDTO.getDescription() != null) {
            existingCourse.setDescription(courseRequestDTO.getDescription());
        }

        if (courseRequestDTO.getInstructor() != null) {
            existingCourse.setInstructor(courseRequestDTO.getInstructor());
        }

        Course updated = courseRepository.save(existingCourse);
        return modelMapper.map(updated, CourseResponseDTO.class);

    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Course Found With Id: " + id));
        courseRepository.delete(course);

    }
}
