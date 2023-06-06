package com.example.controller;

import com.example.application.FicheroService;
import com.example.controller.dto.FicheroInput;
import com.example.controller.dto.FicheroOutput;
import com.example.repository.FicheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/fichero")
public class FicheroController {
    @Autowired
    FicheroService ficheroService;
    @Autowired
    FicheroRepository ficheroRepository;

    @PostMapping
    public ResponseEntity<FicheroOutput> addPerson(@RequestBody FicheroInput ficheroInput) {
        URI location = URI.create("/fichero");
        return ResponseEntity.created(location).body(ficheroService.addFichero(ficheroInput));
    }

    @GetMapping
    public List<?> getAllFicheros(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "4", required = false) int pageSize) {
        return ficheroService.getAllFicheros(pageNumber, pageSize);

    }

}