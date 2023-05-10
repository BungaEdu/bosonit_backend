package com.example.block7crudvalidation.controller;

import com.example.block7crudvalidation.application.StudentServiceImpl;
import com.example.block7crudvalidation.controller.dto.StudentInputDto;
import com.example.block7crudvalidation.controller.dto.StudentOutputDto;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServiceImpl studentServiceImpl;

    @Autowired
    StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<StudentOutputDto> addStudent(@RequestBody StudentInputDto student) throws EntityNotFoundException, UnprocessableEntityException {
        URI location = URI.create("/student");
        if(studentRepository.findById(student.getPersona_id()).isPresent()) {
            return ResponseEntity.created(location).body(studentServiceImpl.addStudent(student));
        } else {
            throw new EntityNotFoundException();
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<StudentOutputDto> updateStudent(@RequestBody StudentInputDto Student, @PathVariable int id) throws Exception {
        studentServiceImpl.updateStudent(Student, id);
        return ResponseEntity.ok().body(studentServiceImpl.getStudentById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentOutputDto> getStudentById(@PathVariable int id) throws EntityNotFoundException{
        try {
            return ResponseEntity.ok().body(studentServiceImpl.getStudentById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("usuario/{usuario}")
    public ResponseEntity<StudentOutputDto> getStudentByUsuario(@PathVariable String Usuario) {
        try {
            return ResponseEntity.ok().body(studentServiceImpl.getStudentByUsuario(Usuario));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<StudentOutputDto> getAllStudents(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "4", required = false) int pageSize) {

        return studentServiceImpl.getAllStudents(pageNumber, pageSize);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudentById(@RequestParam int id) throws EntityNotFoundException{
        try {
            studentServiceImpl.deleteStudentById(id);
            return ResponseEntity.ok().body("Persona con id " + id + " se ha borrado.");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

/*    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomError> handleEntityNotFoundException (EntityNotFoundException ex) {
        CustomError error = ex.getError();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<CustomError> handleUnprocessableEntityException (UnprocessableEntityException ex) {
        CustomError error = ex.getError();
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
    }*/
}
