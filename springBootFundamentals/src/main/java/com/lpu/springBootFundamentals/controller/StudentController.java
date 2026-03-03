package com.lpu.springBootFundamentals.controller;

import com.lpu.springBootFundamentals.Student;
import com.lpu.springBootFundamentals.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){

        this.studentService=studentService;
    }

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student){

        return studentService.save(student);
    }

}
