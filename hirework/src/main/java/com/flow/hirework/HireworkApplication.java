package com.flow.hirework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HireworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(HireworkApplication.class, args);
	}

}
