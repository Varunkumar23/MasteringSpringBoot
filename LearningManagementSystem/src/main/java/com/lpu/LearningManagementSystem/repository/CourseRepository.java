package com.lpu.LearningManagementSystem.repository;

import com.lpu.LearningManagementSystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
