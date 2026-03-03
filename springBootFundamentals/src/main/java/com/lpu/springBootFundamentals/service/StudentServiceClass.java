package com.lpu.springBootFundamentals.service;

import com.lpu.springBootFundamentals.Student;
import com.lpu.springBootFundamentals.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceClass implements StudentService {


    private final StudentRepository studentRepository;

    public StudentServiceClass(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student save(Student student) {
        System.out.println("Student Id: " + student.getId());
        System.out.println("Student Name: " + student.getName());
        return studentRepository.save(student);
    }
}
