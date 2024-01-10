package com.delume;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Find Profile", version = "1", description = "Integration of instagram profiles in google search"))
public class DelumeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DelumeApplication.class, args);
	}
	
	@Override
	public void run(String... enderecoeRepository) throws Exception {
	}

}
