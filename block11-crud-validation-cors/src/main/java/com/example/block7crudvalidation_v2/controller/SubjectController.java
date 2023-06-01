package com.example.block7crudvalidation_v2.controller;

import com.example.block7crudvalidation_v2.application.SubjectService;
import com.example.block7crudvalidation_v2.domain.Subject;
import com.example.block7crudvalidation_v2.dto.input.SubjectInputDto;
import com.example.block7crudvalidation_v2.dto.output.SubjectOutputDto;
import com.example.block7crudvalidation_v2.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation_v2.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation_v2.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @Autowired
    SubjectRepository subjectRepository;

    @PostMapping
    public ResponseEntity<SubjectOutputDto> addSubject(@RequestBody SubjectInputDto subjectInputDto) {
        if (subjectRepository.findById(subjectInputDto.getIdSubject()).isPresent()) {
            throw new UnprocessableEntityException("La asignatura: "
                    + subjectInputDto.getName() + " ya está creada");
        }
        URI location = URI.create("/subject");
        return ResponseEntity.created(location).body(subjectService.addSubject(subjectInputDto));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<SubjectOutputDto> getSubjectId(@PathVariable int id) {
        return ResponseEntity.ok().body(subjectService.getSubjectById(id));
    }

    @GetMapping
    public List<SubjectOutputDto> getAllSubjects(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "4", required = false) int pageSize,
            @RequestParam(value = "outputType", defaultValue = "") String outputType) {
        return subjectService.getAllSubjects(pageNumber, pageSize);
    }

    @PutMapping
    public ResponseEntity<SubjectOutputDto> updateSubject(@RequestBody SubjectInputDto subjectInputDto) {
        if (subjectRepository.findById(subjectInputDto.getIdSubject()).isEmpty()) {
            throw new EntityNotFoundException("El subject con id: " + subjectInputDto.getIdSubject() + " no existe, no se puede actualizar");
        }
        return ResponseEntity.ok().body(subjectService.addSubject(subjectInputDto));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteSubjectById(@PathVariable int id) {
        if (subjectRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("El id: " + id + " no existe, no se puede borrar");
        }
        subjectService.deleteSubjectById(id);
        return ResponseEntity.ok().body("Subject with id: " + id + " was deleted");
    }
}