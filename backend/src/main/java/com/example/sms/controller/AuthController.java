package com.example.sms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.dto.LoginRequestDTO;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO dto){
        if(dto.getUsername().equals("admin") && dto.getPassword().equals("admin"))
        {
            return "JWT_TOKEN";
        }
        return "Invalid Credentials";
    }

}
