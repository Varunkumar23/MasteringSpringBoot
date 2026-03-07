package com.lpu.CourseManagementSystem.repository;

import com.lpu.CourseManagementSystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
