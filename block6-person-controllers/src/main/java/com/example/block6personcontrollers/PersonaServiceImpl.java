package com.example.block6personcontrollers;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Override
    public Persona crearPersona(String nombre, String poblacion, int edad) {
        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setCiudad(poblacion);
        persona.setEdad(edad);
        return persona;
    }
}
