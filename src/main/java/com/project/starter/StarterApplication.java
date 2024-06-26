package com.project.starter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarterApplication implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println(
				"============================================== Service is running ===============================================");
	}

	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);
	}

}
