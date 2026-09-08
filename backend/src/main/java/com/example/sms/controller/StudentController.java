package com.example.sms.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.model.Student;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

    @GetMapping
    public ArrayList<Student> getStudent() {
     ArrayList<Student> students = new ArrayList<>();
      
     students.add(new Student(1, "Ankit", "B.E"));
     students.add(new Student(2, "Rahul", "MCA"));

     return students;
}
}