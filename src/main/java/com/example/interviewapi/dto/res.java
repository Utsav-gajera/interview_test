package com.example.interviewapi.dto;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class res {

    private Long conn;

    private Long to_id;

    private Long from_id;

    private String status;

    private LocalDateTime c_time;

    private LocalDateTime a_time;

}
