package com.example.block7crudvalidation_v2.controller;

import com.example.block7crudvalidation_v2.application.PersonService;
import com.example.block7crudvalidation_v2.controller.dto.PersonInputDto;
import com.example.block7crudvalidation_v2.controller.dto.PersonOutputDto;
import com.example.block7crudvalidation_v2.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation_v2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<PersonOutputDto> addPerson(@RequestBody PersonInputDto personInputDto) {
        URI location = URI.create("/person");
        return ResponseEntity.created(location).body(personService.addPerson(personInputDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonOutputDto> getPersonById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(personService.getPersonById(id));
        } catch (Exception e) {
            throw new EntityNotFoundException("La persona con ID: " + id + " no existe");
        }
    }

    @GetMapping
    public Iterable<PersonOutputDto> getAllPersons(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "4", required = false) int pageSize) {

        return personService.getAllPersons(pageNumber, pageSize);
    }

    @PutMapping
    public ResponseEntity<PersonOutputDto> updatePerson(@RequestBody PersonInputDto personInputDto) {
        if (personRepository.findById(personInputDto.getId_person()).isEmpty()) {
            throw new EntityNotFoundException("El id: " + personInputDto.getId_person() + " no existe, no se puede actualizar");
        }
        return ResponseEntity.ok().body(personService.addPerson(personInputDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable int id) {
        if (personRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("El id: " + id + " no existe, no se puede borrar");
        }
        personService.deletePersonById(id);
        return ResponseEntity.ok().body("Person with id: " + id + " was deleted");
    }
}