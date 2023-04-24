package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controlador1")
public class Controlador1 {
    @Autowired
    PersonaService personaService;
    @GetMapping(value = "/addPersona")
    ///controlador1/addPersona

    public Persona addPersona(@RequestHeader String name,
                        @RequestHeader String poblacion,
                        @RequestHeader int edad) {
        return personaService.crearPersona(name, poblacion, edad);
    }
}