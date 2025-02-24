package com.sandbox.SpringAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication @ComponentScan({"com.sandbox.controller","com.sandbox.service", "com.sandbox.repository" })
@EntityScan( basePackages = {"com.*"})
@EnableJpaRepositories("com.sandbox.repository")
public class SpringApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiApplication.class, args);
	}

}
