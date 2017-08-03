package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication //this encompasses @Configuration, @EnableAutoConfiguration, @ComponentScan
@EnableJpaRepositories //this enables Spring Data
public class Application {
	
	//Spring Boot deploys itself. 
	//Calling SpringApplication.run spins up a tomcat server to run your app
	//Because we're using the actuator, we only need this class to deploy a 
	//Restful webservice

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

}
