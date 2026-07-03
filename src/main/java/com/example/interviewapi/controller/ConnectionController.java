package com.example.interviewapi.controller;

import com.example.interviewapi.dto.AuthResponse;
import com.example.interviewapi.dto.LoginRequest;
import com.example.interviewapi.dto.RegisterRequest;
import com.example.interviewapi.dto.connreq;
import com.example.interviewapi.dto.req;
import com.example.interviewapi.entity.connres;
import com.example.interviewapi.service.ConnectionService;
import com.example.interviewapi.service.UserService;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/conn")
@RequiredArgsConstructor

public class ConnectionController {
    
    private final ConnectionService connectionService;

    @PostMapping("/")
    public ResponseEntity sendRequest(@RequestBody connreq conn,@RequestHeader ("user_id") Long from_id) {
        
        return ResponseEntity.ok(connectionService.sendreq(conn,from_id));        
    }

    @PatchMapping("/res")
    public ResponseEntity resReq(@RequestBody req request,@RequestHeader ("user_id") Long from_id) {
        
        return ResponseEntity.ok(connectionService.resReq(request,from_id));
    }
    
    
}
