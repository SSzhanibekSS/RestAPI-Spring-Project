package com.example.restapi.RestAPISpringProject.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCon {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
