package com.example.interviewapi.controller;

import com.example.interviewapi.dto.AuthResponse;
import com.example.interviewapi.dto.LoginRequest;
import com.example.interviewapi.dto.RegisterRequest;
import com.example.interviewapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {

        String token = userService.register(request);

        return new AuthResponse(token);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        String token = userService.login(request);

        return new AuthResponse(token);
    }
}