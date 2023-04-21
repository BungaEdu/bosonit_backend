package com.example.block6simplecontrollers;

import org.springframework.stereotype.Component;

@Component
public class Persona {
    String name;
    Integer edad;
    String ciudad;
    public Persona(){}

    public Persona(String name, Integer edad, String ciudad) {
        this.name = name;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
