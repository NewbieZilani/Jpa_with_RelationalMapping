package com.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.spring.main")
public class SpringWithRelationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithRelationApplication.class, args);
	}

}
