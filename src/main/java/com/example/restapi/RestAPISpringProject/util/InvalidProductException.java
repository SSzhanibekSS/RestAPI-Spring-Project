package com.example.restapi.RestAPISpringProject.util;

public class InvalidProductException extends RuntimeException{
    public InvalidProductException(String msg){
        super(msg);
    }
}
