package com.example.interviewapi.entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class connres {
 
    private Long id;

    private Long to_id;

    private Long from_id;
}
