package com.flow.hirework;

import com.flow.hirework.service.FileExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
@RequiredArgsConstructor
public class HireworkApplication implements CommandLineRunner {

	private final FileExtensionService extensionService;

	public static void main(String[] args) {
		SpringApplication.run(HireworkApplication.class, args);
	}

	@Override
	public void run(String... args) {
		extensionService.setDefaultData();
	}
}
