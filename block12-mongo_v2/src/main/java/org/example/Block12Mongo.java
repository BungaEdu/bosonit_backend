package org.example;

import org.example.application.PersonService;
import org.example.application.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block12Mongo {
    public static void main(String[] args) {
        SpringApplication.run(Block12Mongo.class, args);
    }

}