package com.example.block7crudvalidation_v2.application;

import com.example.block7crudvalidation_v2.controller.dto.StudentInputDto;
import com.example.block7crudvalidation_v2.controller.dto.StudentOutputDto;
import com.example.block7crudvalidation_v2.controller.dto.StudentOutputDtoSimple;

import java.util.List;

public interface StudentService {
    StudentOutputDto addStudent(StudentInputDto StudentInputDto);
    StudentOutputDtoSimple getStudentById(int id);
    void deleteStudentById( int id);
    List<StudentOutputDtoSimple> getAllStudents(int pageNumber, int pageSize);
    StudentOutputDtoSimple updateStudent(StudentInputDto Student);
}
