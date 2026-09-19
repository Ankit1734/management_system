package com.example.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.dto.LoginRequestDTO;
import com.example.sms.service.JwtService;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO dto){
        if(dto.getUsername().equals("admin") && dto.getPassword().equals("admin"))
        {
            return jwtService.generateToken(
                dto.getUsername()
            );
        }
        return "Invalid Credentials";
    }
    

}
