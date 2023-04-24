package com.example.block6personcontrollers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controlador2")
public class Controlador2 {

    @GetMapping("/getPersona")
    public Persona getPersona(@RequestBody Persona persona) {
        persona.setEdad(persona.getEdad() * 2);
        return persona;
    }
}