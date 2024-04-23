package com.example.restapi.RestAPISpringProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person extends BaseEntity {

    @Column(name = "username")
    @NotEmpty(message = "Username shouldn't be empty")
    private String username;
    @Column(name = "password")
    @NotEmpty(message = "Password shouldn't be empty")
    private String password;
    @Column(name = "full_name")
    @Pattern(regexp = "^([A-Z][a-z]+) ([A-Z][a-z]+) ([A-Z][a-z]+)$",
             message = "Full Name should be int this format 'Shaimurat Zhanibek Kanybekuly'" )
    private String fullName;
    @Column(name = "email")
    @Email(message = "Email is incorrect")
    private String email;
    @Column(name = "photo_url")
    @NotEmpty(message = "URL shouldn't be empty")
    private String photoURL;


}
