package com.lpu.springBootFundamentals.repository;

import com.lpu.springBootFundamentals.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


}
