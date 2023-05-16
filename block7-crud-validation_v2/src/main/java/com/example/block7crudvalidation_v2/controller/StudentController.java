package com.example.block7crudvalidation_v2.controller;

import com.example.block7crudvalidation_v2.application.StudentService;
import com.example.block7crudvalidation_v2.controller.dto.StudentInputDto;
import com.example.block7crudvalidation_v2.controller.dto.StudentOutputDto;
import com.example.block7crudvalidation_v2.controller.dto.StudentOutputDtoSimple;
import com.example.block7crudvalidation_v2.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation_v2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<StudentOutputDto> addStudent(@RequestBody StudentInputDto studentInputDto) {
        URI location = URI.create("/student");
        return ResponseEntity.created(location).body(studentService.addStudent(studentInputDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentOutputDtoSimple> getStudentById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(studentService.getStudentById(id));
        } catch (Exception e) {
            throw new EntityNotFoundException("El student con ID: " + id + " no existe");
        }
    }

    @GetMapping
    public Iterable<StudentOutputDtoSimple> getAllStudents(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "4", required = false) int pageSize) {

        return studentService.getAllStudents(pageNumber, pageSize);
    }

    @PutMapping
    public ResponseEntity<StudentOutputDto> updateStudent(@RequestBody StudentInputDto studentInputDto) {
        if (studentRepository.findById(studentInputDto.getIdStudent()).isEmpty()) {
            throw new EntityNotFoundException("El id: " + studentInputDto.getIdStudent() + " no existe, no se puede actualizar");
        }
        return ResponseEntity.ok().body(studentService.addStudent(studentInputDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
        if (studentRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("El id: " + id + " no existe, no se puede borrar");
        }
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().body("Student with id: " + id + " was deleted");
    }
}