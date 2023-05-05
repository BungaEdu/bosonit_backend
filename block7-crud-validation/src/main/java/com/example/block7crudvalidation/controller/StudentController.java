package com.example.block7crudvalidation.controller;

import com.example.block7crudvalidation.application.StudentServiceImpl;
import com.example.block7crudvalidation.controller.dto.StudentInputDto;
import com.example.block7crudvalidation.controller.dto.StudentOutputDto;
import com.example.block7crudvalidation.exceptions.CustomError;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServiceImpl StudentService;

    @PostMapping
    public ResponseEntity<StudentOutputDto> addStudent(@RequestBody StudentInputDto Student) throws EntityNotFoundException, UnprocessableEntityException{
        URI location = URI.create("/persona");
        return ResponseEntity.created(location).body(StudentService.addStudent(Student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentOutputDto> updateStudent(@RequestBody StudentInputDto Student, @PathVariable int id) throws Exception {
        StudentService.updateStudent(Student, id);
        return ResponseEntity.ok().body(StudentService.getStudentById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentOutputDto> getStudentById(@PathVariable int id) throws EntityNotFoundException{
        try {
            return ResponseEntity.ok().body(StudentService.getStudentById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("usuario/{usuario}")
    public ResponseEntity<StudentOutputDto> getStudentByUsuario(@PathVariable String Usuario) {
        try {
            return ResponseEntity.ok().body(StudentService.getStudentByUsuario(Usuario));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public Iterable<StudentOutputDto> getAllStudents(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "4", required = false) int pageSize) {

        return StudentService.getAllStudents(pageNumber, pageSize);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudentById(@RequestParam int id) throws EntityNotFoundException{
        try {
            StudentService.deleteStudentById(id);
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
