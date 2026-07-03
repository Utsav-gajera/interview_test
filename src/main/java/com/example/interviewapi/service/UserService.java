package com.example.interviewapi.service;

import com.example.interviewapi.dto.LoginRequest;
import com.example.interviewapi.dto.RegisterRequest;
import com.example.interviewapi.entity.User;
import com.example.interviewapi.repository.UserRepository;
import com.example.interviewapi.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final JwtService jwtService;

    public String register(RegisterRequest request) {

        if (repository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        try{User user = new User();
                user.setName(request.getName());
                user.setEmail(request.getEmail());

        repository.save(user);

        return jwtService.generateToken(user.getEmail());}
        catch(Exception e){
            throw new RuntimeException("Something went wrong, please try again");
        }
    }

    // public String login(LoginRequest request) {

    //     // authenticationManager.authenticate(
    //     //         new UsernamePasswordAuthenticationToken(
    //     //                 request.getEmail(),
    //     //                 request.getPassword()
    //     //         )
    //     // );

    //     return jwtService.generateToken(request.getEmail());
    // }
}