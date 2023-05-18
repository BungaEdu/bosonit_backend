package com.example.block7crudvalidation_v2.application;

import com.example.block7crudvalidation_v2.dto.input.TeacherInputDto;
import com.example.block7crudvalidation_v2.dto.output.TeacherOutputDtoFull;
import com.example.block7crudvalidation_v2.dto.output.TeacherOutputDtoSimple;

import java.util.List;

public interface TeacherService {
    TeacherOutputDtoSimple addTeacher(TeacherInputDto TeacherInputDto);
    TeacherOutputDtoSimple getTeacherByIdSimple(int id);

    TeacherOutputDtoFull getTeacherByIdFull(int id);

    void deleteTeacherById( int id);
    List<TeacherOutputDtoSimple> getAllTeachersSimple(int pageNumber, int pageSize);

    List<TeacherOutputDtoFull> getAllTeachersFull(int pageNumber, int pageSize);

    TeacherOutputDtoSimple updateTeacher(TeacherInputDto Teacher);
}
