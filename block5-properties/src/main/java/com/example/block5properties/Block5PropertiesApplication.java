package com.example.block5properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5PropertiesApplication implements CommandLineRunner {
	@Value("${greeting}")
	public String greeting;
	@Value("${my.number}")
	public int number;
	@Value("${new.property: ‘new.property no tiene valor'}")
	public String newProperty;

	public static void main(String[] args) {
		SpringApplication.run(Block5PropertiesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("El valor de greeting: "+greeting);
		System.out.println("El valor de number: "+number);
		System.out.println("El valor de number: "+newProperty);
	}
}
