package com.example.sms.config;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.sms.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class JwtFilter extends OncePerRequestFilter {
    
    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{

	String header = request.getHeader("Authorization");

    if(header != null && header.startsWith("Bearer ")) {
                    String token = header.substring(7);
                    
                    if(jwtService.isValid(token)) {
                        String username = jwtService.extractUsername(token);
                        
                        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
                        
                        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
filterChain.doFilter(request, response);
}
}
