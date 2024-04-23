package com.example.restapi.RestAPISpringProject.util;

import lombok.*;

import java.time.LocalDate;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMsg {
    private LocalDate timestamp;
    private String message;
}
