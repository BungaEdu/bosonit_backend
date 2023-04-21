package com.example.block6simplecontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorAddName {
    String nombre="chuchi";
    Integer edad = 33;
    String ciudad = "Logroño";
    @Autowired
    Persona persona;
    @PostMapping(value = "/useradd")
    public Persona hola () {
        persona.setName(nombre);
        persona.setEdad(edad+1);
        persona.setCiudad(ciudad);
        return persona;
    }
}