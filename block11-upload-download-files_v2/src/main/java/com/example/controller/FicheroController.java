package com.example.controller;

import com.example.application.FicheroService;
import com.example.controller.dto.FicheroInput;
import com.example.controller.dto.FicheroOutput;
import com.example.domain.Fichero;
import com.example.repository.FicheroRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/fichero")
public class FicheroController {
    @Autowired
    FicheroService ficheroService;
    @Autowired
    FicheroRepository ficheroRepository;

//    @PostMapping("/upload/{tipo}")
//    public ResponseEntity<FicheroOutput> addFichero(
//            @PathVariable String tipo,
//            @RequestParam("file") MultipartFile file,
//            @RequestBody FicheroInput ficheroInput) {
//        URI location = URI.create("/fichero");
//        return ResponseEntity.created(location).body(ficheroService.addFichero(ficheroInput));
//    }

    @PostMapping("upload/{tipo}")
    public ResponseEntity<?> uploadFichero(
            @PathVariable String tipo,
            @RequestParam("addFichero") MultipartFile file) {
        String tipoArchivoEsperado = tipo.toLowerCase();
        String tipoArchivoActual = FilenameUtils.getExtension(file.getOriginalFilename()).toLowerCase();
        if (tipoArchivoEsperado.equals(tipoArchivoActual)) {
            String fich = ficheroService.uploadFichero(file);
            if (fich != null) {
                return ResponseEntity.status(HttpStatus.OK).body(fich);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo subir el archivo.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El tipo de archivo no es válido para este endpoint.");
        }
    }




    @GetMapping("/id/{id}")
    public ResponseEntity<?> getFicheroId(@RequestParam(value = "outputType", defaultValue = "simple") String outputType,
                                          @PathVariable int id) {
        return ResponseEntity.ok().body(ficheroService.getFicheroById(id));
    }

    @GetMapping
    public List<?> getAllFicheros(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "4", required = false) int pageSize) {
        return ficheroService.getAllFicheros(pageNumber, pageSize);
    }

}