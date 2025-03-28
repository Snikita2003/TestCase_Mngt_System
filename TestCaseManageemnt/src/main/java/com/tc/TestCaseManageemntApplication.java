package com.tc;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
 

//  http://localhost:8080/swagger-ui.html  

@SpringBootApplication
@EnableWebMvc
public class TestCaseManageemntApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestCaseManageemntApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	
	

}
