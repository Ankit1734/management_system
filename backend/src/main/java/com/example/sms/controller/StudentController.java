package com.example.sms.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.model.Student;
import com.example.sms.service.StudentService;



@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

    @Autowired 
    private final StudentService service;


    @Autowired 
    JdbcTemplate jdbcTemplate;

    public StudentController(StudentService service) { 
        this.service = service; 
    
    } 
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
     @GetMapping 
     public List<Student> getStudent() { 
        return service.getAllStudents(); 
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
@GetMapping("/count")
public int countStudents() {

    String sql = "SELECT COUNT(*) FROM student";

    return jdbcTemplate.queryForObject(
            sql,
            Integer.class
    );
}
@GetMapping("/message")
public String getMessage(){
    return service.getMessage();
}
@GetMapping("/counts")
public Integer countStudent(){
    return service.getStudentCount();
}





}