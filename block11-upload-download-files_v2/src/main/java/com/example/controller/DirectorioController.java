package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class DirectorioController {

    private String directorioGuardado;

    @GetMapping("/setpath")
    public ResponseEntity<String> setDirectorio(@RequestParam("path") String path) {
        // Verificar si el directorio existe
        File directorio = new File(path);
        if (!directorio.exists() || !directorio.isDirectory()) {
            return ResponseEntity.badRequest().body("El directorio especificado no existe.");
        }

        // Asignar el directorio de guardado
        directorioGuardado = path;

        return ResponseEntity.ok("Directorio de guardado actualizado correctamente.");
    }

    // Este método devuelve el directorio de guardado actual
    public String getDirectorioGuardado() {
        return directorioGuardado;
    }
}

