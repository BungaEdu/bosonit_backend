package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.dto.StudentInputDto;
import com.example.block7crudvalidation.controller.dto.StudentOutputDto;
import com.example.block7crudvalidation.exceptions.CustomError;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;

import java.util.List;

public interface StudentService {
    StudentOutputDto addStudent(StudentInputDto student) throws Exception, CustomError;

    StudentOutputDto getStudentById(int id);

    void deleteStudentById(int id);

    List<StudentOutputDto> getAllStudents(int pageNumber, int pageSize);

    StudentOutputDto getStudentByUsuario(String usuario);

    StudentOutputDto updateStudent(StudentInputDto Student, int id) throws EntityNotFoundException, UnprocessableEntityException;
}
