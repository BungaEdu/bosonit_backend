package com.example.block6simplecontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controladorPrueba {
    String nombre;

    @RequestMapping("/")
    @GetMapping(value = "/users/{nombre}")
    public String hola() {
        return "Hola " + nombre;
    }
}