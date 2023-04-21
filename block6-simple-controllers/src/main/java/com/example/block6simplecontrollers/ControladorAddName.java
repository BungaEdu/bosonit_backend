package com.example.block6simplecontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorAddName {
    @PostMapping(value = "/useradd")
    public String hola (@PathVariable String name) {
        return "Hola " + name;
    }
}