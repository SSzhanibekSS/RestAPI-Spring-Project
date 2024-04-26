package com.example.restapi.RestAPISpringProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.Builder;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.ui.Model;

import java.util.List;

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
