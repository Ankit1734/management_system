package com.example.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service 
public class StudentService {
    
    public String getMessage(){
        return  "Student service working";

    }
    @Autowired 
    JdbcTemplate jdbcTemplate;

    public Integer getStudentCount(){
        String sql = "SELECT COUNT(*) FROM student";

        return jdbcTemplate.queryForObject(
            sql, 
            Integer.class);
    }
    
}
