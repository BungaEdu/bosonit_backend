package org.example.controller;

import org.example.application.PersonService;
import org.example.controller.dto.PersonOutputDto;
import org.example.controller.dto.PersonInputDto;
import org.example.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity<PersonOutputDto> addPerson(@RequestBody PersonInputDto personInputDto) {
        URI location = URI.create("/person");
        return ResponseEntity.created(location).body(personService.addPerson(personInputDto));
    }

    @GetMapping
    public ResponseEntity<List<PersonOutputDto>> getAllPersons(){
        List<PersonOutputDto> persons = new ArrayList<>();
        for (Person person:personService.getAllPerson()){
            persons.add(person.personToPersonOutputDto());
        }
        return ResponseEntity.ok(persons);
    }
    @GetMapping("/getAllPaginated")
    public ResponseEntity<List<PersonOutputDto>> getAllPersonsPaginated(@RequestParam(defaultValue = "0", required = false) int numPages,
                                                                         @RequestParam(defaultValue = "5", required = false) int pageSize) {
        List<PersonOutputDto> personsList = new ArrayList<>();
        for (Person person:personService.getAllPersonPaginated(numPages, pageSize)){
            personsList.add(person.personToPersonOutputDto());
        }
        return ResponseEntity.ok(personsList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PersonOutputDto> getPersonById(@PathVariable("id") String id) {
        try {
            Person person = personService.getPersonById(id);
            return ResponseEntity.ok(person.personToPersonOutputDto());
        } catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonOutputDto> updatePerson(@PathVariable("id") String id, @RequestBody Person updatedPerson) {
        return ResponseEntity.ok().body(personService.updateOnePerson(updatedPerson,id).personToPersonOutputDto());

    }

//    @DeleteMapping
//    public ResponseEntity<String> deletePerson(@RequestParam Person person) {
//        try {
//            personService.deletePerson(person);
//            return ResponseEntity.ok().body("La persona " + person.getName() + " se ha borrado.");
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
}