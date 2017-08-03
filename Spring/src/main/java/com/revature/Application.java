package com.revature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.revature.dao.BookRepository;
import com.revature.service.BookService;

@SpringBootApplication
@EnableJpaRepositories
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
}
