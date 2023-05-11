package com.example.block7crudvalidation_v2.application;

import com.example.block7crudvalidation_v2.controller.dto.StudentInputDto;
import com.example.block7crudvalidation_v2.controller.dto.StudentOutputDto;

public interface StudentService {
    StudentOutputDto addStudent(StudentInputDto StudentInputDto);
    StudentOutputDto getStudentById(int id);
    void deleteStudentById( int id);
    Iterable<StudentOutputDto> getAllStudents(int pageNumber, int pageSize);
    StudentOutputDto updateStudent(StudentInputDto Student);
}
