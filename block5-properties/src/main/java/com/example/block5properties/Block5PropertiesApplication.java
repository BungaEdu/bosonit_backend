package com.example.block5properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5PropertiesApplication {
	@Value("${gretting}") {
		public static String gretting;
	}
	public static void main(String[] args) {

		SpringApplication.run(Block5PropertiesApplication.class, args);
	}

}
