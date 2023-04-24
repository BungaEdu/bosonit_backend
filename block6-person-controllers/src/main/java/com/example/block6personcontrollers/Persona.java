package com.example.block6personcontrollers;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Component
public class Persona {
    String nombre;
    Integer edad;
    String ciudad;

    public Persona() {

    }
}
