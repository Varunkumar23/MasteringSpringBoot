package com.lpu.LearningManagementSystem.repository;

import com.lpu.LearningManagementSystem.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
