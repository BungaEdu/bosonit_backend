package com.example.block6simplecontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorName {
    //@RequestMapping("/") //No se utiliza @request con @get, porque colisionan
    @GetMapping(value = "/user/{name}")
    public String hola (@PathVariable String name) { //Path es para introducir la variable de la ruta
        return "Hola " + name;
    }
}