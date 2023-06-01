package com.example.block7crudvalidation_v2.controller;

import com.example.block7crudvalidation_v2.application.TeacherService;
import com.example.block7crudvalidation_v2.dto.input.TeacherInputDto;
import com.example.block7crudvalidation_v2.dto.output.TeacherOutputDtoSimple;
import com.example.block7crudvalidation_v2.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation_v2.exceptions.OutputTypeNotFoundException;
import com.example.block7crudvalidation_v2.exceptions.UnprocessableEntityException;
//import com.example.block7crudvalidation_v2.feign.TeacherFeignClient;
import com.example.block7crudvalidation_v2.repository.StudentRepository;
import com.example.block7crudvalidation_v2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    StudentRepository studentRepository;

//    private final TeacherFeignClient teacherFeignClient;
//
//    public TeacherController(TeacherFeignClient teacherFeignClient) {
//        this.teacherFeignClient = teacherFeignClient;
//    }
//
//    @GetMapping ("/{id}")
//    public TeacherOutputDtoSimple getTeacherFeignById (@PathVariable int id) {
//        return teacherFeignClient.getTeacherByIdSimple(id);
//    }


    @PostMapping
    public ResponseEntity<TeacherOutputDtoSimple> addTeacher(@RequestBody TeacherInputDto teacherInputDto) {
        if (teacherRepository.findByPersonIdPerson(teacherInputDto.getIdPerson()).isPresent()) {
            throw new UnprocessableEntityException("La persona con ID: "
                    + teacherInputDto.getIdPerson() + " ya tiene un teacher asignado");
        }
        if (studentRepository.findByPersonIdPerson(teacherInputDto.getIdPerson()).isPresent()) {
            throw new UnprocessableEntityException("La persona con ID: "
                    + teacherInputDto.getIdPerson() + " es un student, no puede ser teacher a la vez");
        }
        URI location = URI.create("/teacher");
        return ResponseEntity.created(location).body(teacherService.addTeacher(teacherInputDto));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getTeacherId(@RequestParam(value = "outputType", defaultValue = "simple") String outputType,
                                          @PathVariable int id) {
        if (outputType.equalsIgnoreCase("full")) {
            return ResponseEntity.ok().body(teacherService.getTeacherByIdFull(id));
        } else if (outputType.equalsIgnoreCase("simple")) {
            return ResponseEntity.ok().body(teacherService.getTeacherByIdSimple(id));
        } else {
            throw new OutputTypeNotFoundException("outputType incorrecto (full/simple)");
        }
    }

    @GetMapping
    public List<?> getAllTeachers(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "4", required = false) int pageSize,
            @RequestParam(value = "outputType", defaultValue = "simple") String outputType) {
        if (outputType.equalsIgnoreCase("full")) {
            return teacherService.getAllTeachersFull(pageNumber, pageSize);
        } else if (outputType.equalsIgnoreCase("simple")) {
            return teacherService.getAllTeachersSimple(pageNumber, pageSize);
        } else {
            throw new OutputTypeNotFoundException("outputType incorrecto (full/simple)");
        }
    }

    @PutMapping
    public ResponseEntity<TeacherOutputDtoSimple> updateTeacher(@RequestBody TeacherInputDto teacherInputDto) {
        if (teacherRepository.findById(teacherInputDto.getIdTeacher()).isEmpty()) {
            throw new EntityNotFoundException("El teacher con id: " + teacherInputDto.getIdTeacher() + " no existe, no se puede actualizar");
        }
        return ResponseEntity.ok().body(teacherService.addTeacher(teacherInputDto));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteTeacherById(@PathVariable int id) {
        if (teacherRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("El id: " + id + " no existe, no se puede borrar");
        }
        teacherService.deleteTeacherById(id);
        return ResponseEntity.ok().body("Teacher with id: " + id + " was deleted");
    }
}