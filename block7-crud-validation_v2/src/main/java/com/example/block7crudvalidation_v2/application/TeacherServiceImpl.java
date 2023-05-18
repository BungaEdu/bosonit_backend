package com.example.block7crudvalidation_v2.application;

import com.example.block7crudvalidation_v2.dto.input.TeacherInputDto;
import com.example.block7crudvalidation_v2.dto.output.TeacherOutputDtoFull;
import com.example.block7crudvalidation_v2.dto.output.TeacherOutputDtoSimple;
import com.example.block7crudvalidation_v2.domain.Teacher;
import com.example.block7crudvalidation_v2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public TeacherOutputDtoSimple addTeacher(TeacherInputDto teacherInputDto) {
        return teacherRepository.save(new Teacher(teacherInputDto))
                .teacherToTeacherOutputDtoSimple();
    }

    @Override
    public TeacherOutputDtoSimple getTeacherByIdSimple(int id) {
        return teacherRepository.findById(id).orElseThrow()
                .teacherToTeacherOutputDtoSimple();
    }

    @Override
    public TeacherOutputDtoFull getTeacherByIdFull(int id) {
        return teacherRepository.findById(id).orElseThrow()
                .teacherToTeacherOutputDtoFull();
    }


    @Override
    public List<TeacherOutputDtoSimple> getAllTeachersSimple(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return teacherRepository.findAll(pageRequest).getContent()
                .stream()
                .map(Teacher::teacherToTeacherOutputDtoSimple).toList();
    }

    @Override
    public List<TeacherOutputDtoFull> getAllTeachersFull(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return teacherRepository.findAll(pageRequest).getContent()
                .stream()
                .map(Teacher::teacherToTeacherOutputDtoFull).toList();
    }

    @Override
    public TeacherOutputDtoSimple updateTeacher(TeacherInputDto teacherInputDto) {
        return teacherRepository.save(new Teacher(teacherInputDto))
                .teacherToTeacherOutputDtoSimple();
    }

    @Override
    public void deleteTeacherById(int id) {
        teacherRepository.deleteById(id);
    }
}
