package com.example.block7crudvalidation_v2.application;

import com.example.block7crudvalidation_v2.controller.dto.StudentInputDto;
import com.example.block7crudvalidation_v2.controller.dto.StudentOutputDto;
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
    public StudentOutputDto addStudent(StudentInputDto studentInputDto) {
        return studentRepository.save(new Student(studentInputDto))
                .studentToStudentOutputDto(studentInputDto);
    }

    @Override
    public StudentOutputDtoSimple getStudentById(int id) {
        return studentRepository.findById(id).orElseThrow()
                .studentToStudentOutputDtoSimple();
    }


    @Override
    public List<StudentOutputDtoSimple> getAllStudents(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return studentRepository.findAll(pageRequest).getContent()
                .stream()
                .map(Student::studentToStudentOutputDtoSimple).toList();
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
