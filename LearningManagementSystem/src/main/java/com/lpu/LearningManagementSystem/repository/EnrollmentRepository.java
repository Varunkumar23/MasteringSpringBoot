package com.lpu.LearningManagementSystem.repository;

import com.lpu.LearningManagementSystem.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
}
