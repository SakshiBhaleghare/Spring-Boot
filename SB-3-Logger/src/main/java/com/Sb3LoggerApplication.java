package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sb3LoggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sb3LoggerApplication.class, args);
		System.out.println("Normal java app");
	}

}
