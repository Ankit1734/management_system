
package com.example.sms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sms.dto.StudentRequestDTO;
import com.example.sms.exception.StudentNotFoundException;
import com.example.sms.model.Student;
import com.example.sms.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student addStudent(StudentRequestDTO dto) {

    Student student = new Student();
    
    student.setName(dto.getName());
    student.setCourse(dto.getCourse());

    return repository.save(student);
}
    public Student updateStudent(Integer id, StudentRequestDTO dto){
        Student existingStudent = repository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Student not found"));

                            existingStudent.setName(dto.getName());  
                            existingStudent.setCourse(dto.getCourse());
                            
                            return repository.save(existingStudent);
    }
    public String deleteStudent(Integer id){
        repository.deleteById(id);
        return "Student Deleted";
    }
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Integer getStudentCount() {
        return (int) repository.count();
    }

    public String getMessage() {
        return "Hello from Student Service";
    }
    public Student getStudentById(Integer id) {

    return repository
            .findById(id)
            .orElseThrow(
                    () -> new StudentNotFoundException("Student Not Found")
            );
}
}

