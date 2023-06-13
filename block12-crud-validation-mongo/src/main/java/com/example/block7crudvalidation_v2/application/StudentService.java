package com.example.block7crudvalidation_v2.application;

import com.example.block7crudvalidation_v2.dto.input.StudentInputDto;
import com.example.block7crudvalidation_v2.dto.output.StudentOutputDtoFull;
import com.example.block7crudvalidation_v2.dto.output.StudentOutputDtoSimple;

import java.util.List;

public interface StudentService {
    StudentOutputDtoSimple addStudent(StudentInputDto StudentInputDto);

    StudentOutputDtoSimple addSubjectToStudent(int id, List<Integer> idList);

    StudentOutputDtoSimple removeSubjectsToStudent(int id, List<Integer> idList);

    StudentOutputDtoSimple getStudentByIdSimple(int id);

    StudentOutputDtoFull getStudentByIdFull(int id);

    void deleteStudentById( int id);
    List<StudentOutputDtoSimple> getAllStudentsSimple(int pageNumber, int pageSize);

    List<StudentOutputDtoFull> getAllStudentsFull(int pageNumber, int pageSize);

    StudentOutputDtoSimple updateStudent(StudentInputDto Student);

}
