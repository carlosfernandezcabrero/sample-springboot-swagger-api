package com.cfernandez.samplespringbootswaggerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:database.properties")
public class SampleSpringbootSwaggerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringbootSwaggerApiApplication.class, args);
	}

}
