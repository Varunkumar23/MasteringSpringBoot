package com.lpu.LearningManagementSystem.repository;

import com.lpu.LearningManagementSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
