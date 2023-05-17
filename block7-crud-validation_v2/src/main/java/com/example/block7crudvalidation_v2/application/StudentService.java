package com.example.block7crudvalidation_v2.application;

import com.example.block7crudvalidation_v2.controller.dto.StudentInputDto;
import com.example.block7crudvalidation_v2.controller.dto.StudentOutputDtoFull;
import com.example.block7crudvalidation_v2.controller.dto.StudentOutputDtoSimple;

import java.util.List;

public interface StudentService {
    StudentOutputDtoSimple addStudent(StudentInputDto StudentInputDto);
    StudentOutputDtoSimple getStudentByIdSimple(int id);

    StudentOutputDtoFull getStudentByIdFull(int id);

    void deleteStudentById( int id);
    List<StudentOutputDtoSimple> getAllStudentsSimple(int pageNumber, int pageSize);

    List<StudentOutputDtoFull> getAllStudentsFull(int pageNumber, int pageSize);

    StudentOutputDtoSimple updateStudent(StudentInputDto Student);
}
