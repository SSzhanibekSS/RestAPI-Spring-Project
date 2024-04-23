package com.example.restapi.RestAPISpringProject.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class PersonDTO {
    @NotEmpty(message = "Username shouldn't be empty")
    private String username;

    @NotEmpty(message = "Password shouldn't be empty")
    private String password;

    @NotEmpty(message = "Password shouldn't be empty")
    private String confirmPassword;

    @Pattern(regexp = "^([A-Z][a-z]+) ([A-Z][a-z]+) ([A-Z][a-z]+)$",
            message = "Full Name should be int this format 'Shaimurat Zhanibek Kanybekuly'" )
    private String fullName;

    @Email(message = "Email is incorrect")
    private String email;

    @NotEmpty(message = "URL shouldn't be empty")
    private String photoURL;

}
