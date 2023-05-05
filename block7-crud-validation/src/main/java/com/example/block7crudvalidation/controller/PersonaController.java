package com.example.block7crudvalidation.controller;

import com.example.block7crudvalidation.application.PersonaServiceImpl;
import com.example.block7crudvalidation.controller.dto.PersonaInputDto;
import com.example.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.example.block7crudvalidation.exceptions.CustomError;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    PersonaServiceImpl personaService;

    @PostMapping
    public ResponseEntity<PersonaOutputDto> addPersona(@RequestBody PersonaInputDto persona) throws EntityNotFoundException, UnprocessableEntityException{
        URI location = URI.create("/persona");
        return ResponseEntity.created(location).body(personaService.addPersona(persona));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> updatePersona(@RequestBody PersonaInputDto Persona, @PathVariable int id) throws Exception {
        personaService.updatePersona(Persona, id);
        return ResponseEntity.ok().body(personaService.getPersonaById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> getPersonaById(@PathVariable int id) throws EntityNotFoundException{
        try {
            return ResponseEntity.ok().body(personaService.getPersonaById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("usuario/{usuario}")
    public ResponseEntity<PersonaOutputDto> getPersonaByUsuario(@PathVariable String Usuario) {
        try {
            return ResponseEntity.ok().body(personaService.getPersonaByUsuario(Usuario));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public Iterable<PersonaOutputDto> getAllPersonas(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "4", required = false) int pageSize) {

        return personaService.getAllPersonas(pageNumber, pageSize);
    }

    @DeleteMapping
    public ResponseEntity<String> deletePersonaById(@RequestParam int id) throws EntityNotFoundException{
        try {
            personaService.deletePersonaById(id);
            return ResponseEntity.ok().body("Persona con id " + id + " se ha borrado.");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomError> handleEntityNotFoundException (EntityNotFoundException ex) {
        CustomError error = ex.getError();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<CustomError> handleUnprocessableEntityException (UnprocessableEntityException ex) {
        CustomError error = ex.getError();
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
    }
}
