package com.example.sms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
      
    students.add(new Student(1, "John", "Mca"));
    students.add(new Student(2, "Tushar", "Bca"));
    students.add(new Student(3, "Aman", "Bca"));
    students.add(new Student(2, "Rahul", "Mca"));
    students.add(new Student(3, "Ajay", "Mca"));

    return students;
}
@GetMapping("/bca")
public List<Student> getBcaStudent(){
    return getStudent().stream()
                    .filter((Student -> "Bca".equals(Student.getCourse())))
                    .collect(Collectors.toList());
    
}
@GetMapping("/name")
public List<String> getName(){
    return getStudent().stream()
                       .map(Student::getName)
                       .collect(Collectors.toList());
}


}