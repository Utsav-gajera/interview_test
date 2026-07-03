package com.example.interviewapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.interviewapi.entity.Connection;

public interface ConnectionRepository extends JpaRepository<Connection,Long> {
    
}
