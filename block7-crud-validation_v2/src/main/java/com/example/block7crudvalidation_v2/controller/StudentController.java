package com.example.block7crudvalidation_v2.controller;

import com.example.block7crudvalidation_v2.application.StudentService;
import com.example.block7crudvalidation_v2.dto.input.StudentInputDto;
import com.example.block7crudvalidation_v2.dto.output.StudentOutputDtoSimple;
import com.example.block7crudvalidation_v2.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation_v2.exceptions.OutputTypeNotFoundException;
import com.example.block7crudvalidation_v2.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation_v2.repository.StudentRepository;
import com.example.block7crudvalidation_v2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @PostMapping
    public ResponseEntity<StudentOutputDtoSimple> addStudent(@RequestBody StudentInputDto studentInputDto) {
        if (studentRepository.findByPersonIdPerson(studentInputDto.getIdPerson()).isPresent()) {
            throw new UnprocessableEntityException("La persona con ID: "
                    + studentInputDto.getIdPerson() + " ya tiene un Student asignado");
        }
        if (teacherRepository.findByPersonIdPerson(studentInputDto.getIdPerson()).isPresent()) {
            throw new UnprocessableEntityException("La persona con ID: "
                    + studentInputDto.getIdPerson() + " es un student, no puede ser teacher a la vez");
        }
        URI location = URI.create("/student");
        return ResponseEntity.created(location).body(studentService.addStudent(studentInputDto));
    }

    @PutMapping("/addSubjectsToStudent/{idStudent}")
    public ResponseEntity<StudentOutputDtoSimple> addSubjectsToStudent(@PathVariable int idStudent,
                                                                       @RequestParam ("idList") List<Integer> idList){
        try {
            studentService.addSubjectToStudent(idStudent, idList);
            return ResponseEntity.ok().body(studentService.getStudentByIdSimple(idStudent));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/removeAsignatura/{idStudent}")
    public ResponseEntity<StudentOutputDtoSimple> removeEstudiosToStudent(@PathVariable int idStudent,
                                                                          @RequestParam List<Integer> idList){
        try {
            studentService.removeSubjectsToStudent(idStudent, idList);
            return ResponseEntity.ok().body(studentService.getStudentByIdSimple(idStudent));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getStudentId(@RequestParam(value = "outputType", defaultValue = "simple") String outputType,
                                          @PathVariable int id) {
        if (outputType.equalsIgnoreCase("full")) {
            return ResponseEntity.ok().body(studentService.getStudentByIdFull(id));
        } else if (outputType.equalsIgnoreCase("simple")) {
            return ResponseEntity.ok().body(studentService.getStudentByIdSimple(id));
        } else {
            throw new OutputTypeNotFoundException("outputType incorrecto (full/simple)");
        }
    }


    @GetMapping
    public List<?> getAllStudents(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "4", required = false) int pageSize,
            @RequestParam(value = "outputType", defaultValue = "simple") String outputType) {
        if (outputType.equalsIgnoreCase("full")) {
            return studentService.getAllStudentsFull(pageNumber, pageSize);
        } else if (outputType.equalsIgnoreCase("simple")) {
            return studentService.getAllStudentsSimple(pageNumber, pageSize);
        } else {
            throw new OutputTypeNotFoundException("outputType incorrecto (full/simple)");
        }
    }

    @PutMapping
    public ResponseEntity<StudentOutputDtoSimple> updateStudent(@RequestBody StudentInputDto studentInputDto) {
        if (studentRepository.findById(studentInputDto.getIdStudent()).isEmpty()) {
            throw new EntityNotFoundException("El student con id: " + studentInputDto.getIdStudent() + " no existe, no se puede actualizar");
        }
        return ResponseEntity.ok().body(studentService.addStudent(studentInputDto));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
        if (studentRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("El id: " + id + " no existe, no se puede borrar");
        }
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().body("Student with id: " + id + " was deleted");
    }
}