package com.example.block7crudvalidation_v2.application;

import com.example.block7crudvalidation_v2.controller.dto.TeacherInputDto;
import com.example.block7crudvalidation_v2.controller.dto.TeacherOutputDtoFull;
import com.example.block7crudvalidation_v2.controller.dto.TeacherOutputDtoSimple;

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
