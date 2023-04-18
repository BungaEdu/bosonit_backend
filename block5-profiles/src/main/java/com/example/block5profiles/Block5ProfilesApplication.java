package com.example.block5profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5ProfilesApplication {

    @Value("${animal}")
    public String profile;

    public static void main(String[] args) {
        SpringApplication.run(Block5ProfilesApplication.class, args);
    }

    public void run(String... args) throws Exception {
        System.out.println("El valor de la url es: " + profile);
    }
}