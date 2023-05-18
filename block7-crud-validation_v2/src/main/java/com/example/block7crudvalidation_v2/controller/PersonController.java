package com.example.block7crudvalidation_v2.controller;

import com.example.block7crudvalidation_v2.application.PersonService;
import com.example.block7crudvalidation_v2.controller.dto.PersonInputDto;
import com.example.block7crudvalidation_v2.controller.dto.PersonOutputDto;
import com.example.block7crudvalidation_v2.controller.dto.PersonStudentOutputDto;
import com.example.block7crudvalidation_v2.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation_v2.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation_v2.repository.PersonRepository;
import com.example.block7crudvalidation_v2.repository.StudentRepository;
import com.example.block7crudvalidation_v2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Objects;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @PostMapping
    public ResponseEntity<PersonOutputDto> addPerson(@RequestBody PersonInputDto personInputDto) {
        URI location = URI.create("/person");
        return ResponseEntity.created(location).body(personService.addPerson(personInputDto));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PersonOutputDto> getPersonById(@RequestParam(value = "outputType", defaultValue = "simple")
                                                         String outputType,
                                                         @PathVariable int id) {
        try {
            if (outputType.equalsIgnoreCase("full")) {
                PersonOutputDto personOutputDto = personService.getPersonByIdFull(id);
                if (personOutputDto instanceof PersonStudentOutputDto personStudentOutputDto) {
                    return ResponseEntity.ok().body(personStudentOutputDto);
                } else {
                    return ResponseEntity.ok().body(personOutputDto);
                }
            } else if (outputType.equalsIgnoreCase("simple")){
                PersonOutputDto personOutputDto = personService.getPersonByIdSimple(id);
                return ResponseEntity.ok().body(personOutputDto);
            } else {
                throw new Exception("outputType incorrecto (full/simple)");
            }
        } catch (Exception e) {
            throw new EntityNotFoundException("La persona con ID: " + id + " no existe");
        }
    }


    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<PersonOutputDto> getPersonByUsuario(@RequestParam(value = "outputType", defaultValue = "simple")
                                                         String outputType,
                                                         @PathVariable String usuario) {
        try {
            if (outputType.equalsIgnoreCase("full")) {
                PersonOutputDto personOutputDto = personService.getPersonByUsuarioFull(usuario);
                if (personOutputDto instanceof PersonStudentOutputDto personStudentOutputDto) {
                    return ResponseEntity.ok().body(personStudentOutputDto);
                } else {
                    return ResponseEntity.ok().body(personOutputDto);
                }
            } else if (outputType.equalsIgnoreCase("simple")){
                PersonOutputDto personOutputDto = personService.getPersonByUsuarioSimple(usuario);
                return ResponseEntity.ok().body(personOutputDto);
            } else {
                throw new Exception("outputType incorrecto (full/simple)");
            }
        } catch (Exception e) {
            throw new EntityNotFoundException("El usuario: " + usuario + " no existe");
        }
    }

    @GetMapping
    public Iterable<PersonOutputDto> getAllPersons(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "4", required = false) int pageSize,
            @RequestParam(value = "outputType", defaultValue = "simple")
            String outputType) throws Exception {
        if (outputType.equalsIgnoreCase("full")) {
            return personService.getAllPersonsFull(pageNumber, pageSize);
        } else if (outputType.equalsIgnoreCase("simple")){
            return personService.getAllPersonsSimple(pageNumber, pageSize);
        } else {
            throw new Exception ("outputType incorrecto (full/simple)");
        }
    }

    @PutMapping
    public ResponseEntity<PersonOutputDto> updatePerson(@RequestBody PersonInputDto personInputDto) {
        if (personRepository.findById(personInputDto.getIdPerson()).isEmpty()) {
            throw new EntityNotFoundException("La person con id: " + personInputDto.getIdPerson() + " no existe, no se puede actualizar");
        }
        return ResponseEntity.ok().body(personService.addPerson(personInputDto));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable int id) {
        if (personRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("El id: " + id + " no existe, no se puede borrar");
        }
        personService.deletePersonById(id);
        return ResponseEntity.ok().body("Person with id: " + id + " was deleted");
    }
}