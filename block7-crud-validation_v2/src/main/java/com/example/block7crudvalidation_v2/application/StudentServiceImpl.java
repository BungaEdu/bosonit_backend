package com.example.block7crudvalidation_v2.application;

import com.example.block7crudvalidation_v2.controller.dto.StudentInputDto;
import com.example.block7crudvalidation_v2.controller.dto.StudentOutputDtoFull;
import com.example.block7crudvalidation_v2.controller.dto.StudentOutputDtoSimple;
import com.example.block7crudvalidation_v2.domain.Student;
import com.example.block7crudvalidation_v2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentOutputDtoSimple addStudent(StudentInputDto studentInputDto) {
        return studentRepository.save(new Student(studentInputDto))
                .studentToStudentOutputDtoSimple();
    }

    @Override
    public StudentOutputDtoSimple getStudentByIdSimple(int id) {
        return studentRepository.findById(id).orElseThrow()
                .studentToStudentOutputDtoSimple();
    }

    @Override
    public StudentOutputDtoFull getStudentByIdFull(int id) {
        return studentRepository.findById(id).orElseThrow()
                .studentToStudentOutputDtoFull();
    }


    @Override
    public List<StudentOutputDtoSimple> getAllStudentsSimple(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return studentRepository.findAll(pageRequest).getContent()
                .stream()
                .map(Student::studentToStudentOutputDtoSimple).toList();
    }

    @Override
    public List<StudentOutputDtoFull> getAllStudentsFull(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return studentRepository.findAll(pageRequest).getContent()
                .stream()
                .map(Student::studentToStudentOutputDtoFull).toList();
    }

    @Override
    public StudentOutputDtoSimple updateStudent(StudentInputDto studentInputDto) {
        return studentRepository.save(new Student(studentInputDto)).studentToStudentOutputDtoSimple();
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }
}
