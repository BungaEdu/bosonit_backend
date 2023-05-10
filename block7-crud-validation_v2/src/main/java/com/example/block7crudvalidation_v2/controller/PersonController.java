package com.example.block7crudvalidation_v2.controller;

import com.example.block7crudvalidation_v2.application.PersonService;
import com.example.block7crudvalidation_v2.controller.dto.PersonInputDto;
import com.example.block7crudvalidation_v2.controller.dto.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity<PersonOutputDto> addperson(@RequestBody PersonInputDto personInputDto) {
        URI location = URI.create("/person");
        return ResponseEntity.created(location).body(personService.addPerson(personInputDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonOutputDto> getPersonById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(personService.getPersonById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable int id) {
        try {
            personService.deletePersonById(id);
            return ResponseEntity.ok().body("Person with id: " + id + " was deleted");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
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
        try {
            personService.getPersonById(personInputDto.getId_person());
            return ResponseEntity.ok().body(personService.addPerson(personInputDto));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

