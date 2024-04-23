package com.example.restapi.RestAPISpringProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.ui.Model;

@SpringBootApplication
public class RestApiSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiSpringProjectApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}
