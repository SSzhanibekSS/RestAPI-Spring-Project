package com.example.restapi.RestAPISpringProject.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthDTO {
    private String username;
    private String password;
}
