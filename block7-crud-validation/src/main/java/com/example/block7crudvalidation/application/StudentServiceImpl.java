package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.dto.StudentInputDto;
import com.example.block7crudvalidation.controller.dto.StudentOutputDto;
import com.example.block7crudvalidation.domain.Student;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository StudentRepository;

    @Override
    public StudentOutputDto getStudentById(int id) {
        return StudentRepository.findById(id).orElseThrow()
                .StudentToStudentOutputDto();
    }

    @Override
    public Iterable<StudentOutputDto> getAllStudents(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return StudentRepository.findAll(pageRequest).getContent()
                .stream()
                .map(Student::StudentToStudentOutputDto).toList();
    }

    @Override
    public void deleteStudentById(int id) {
        StudentRepository.findById(id).orElseThrow();
        StudentRepository.deleteById(id);
    }

    @Override
    public StudentOutputDto getStudentByUsuario(String usuario) {
        return (StudentOutputDto) StudentRepository.findByUsuario(usuario).orElseThrow();
    }

    @Override
    public StudentOutputDto addStudent(StudentInputDto Student) throws EntityNotFoundException, UnprocessableEntityException {
        if (Student.getUsuario() == null || Student.getUsuario().length() < 6 || Student.getUsuario().length() > 10) {
            throw new UnprocessableEntityException();
        }
        if (Student.getPassword() == null) {
            throw new UnprocessableEntityException();
        }
        if (Student.getName() == null) {
            throw new UnprocessableEntityException();
        }
        if (Student.getCompanyEmail() == null) {
            throw new UnprocessableEntityException();
        }
        if (Student.getStudentlEmail() == null) {
            throw new UnprocessableEntityException();
        }
        if (Student.getCity() == null) {
            throw new UnprocessableEntityException();
        }
        if (Student.getActive() == null) {
            throw new UnprocessableEntityException();
        }
        if (Student.getCreatedDate() == null) {
            throw new UnprocessableEntityException();
        }
        return StudentRepository.save(new Student(student)).StudentToStudentOutputDto();
    }

    @Override
    public StudentOutputDto updateStudent(StudentInputDto Student, int id) throws EntityNotFoundException, UnprocessableEntityException {
        Student StudentAct = StudentRepository.findById(id).orElseThrow();
        if (Student.getUsuario() != null || Student.getUsuario().length() >= 6 || Student.getUsuario().length() <= 10) {
            StudentAct.setUsuario(Student.getUsuario());
        } else {
            throw new UnprocessableEntityException();
        }
        if (Student.getPassword() != null) {
            StudentAct.setPassword(Student.getPassword());
        } else {
            throw new UnprocessableEntityException();
        }
        if (Student.getName() != null) {
            StudentAct.setName(Student.getName());
        } else {
            throw new UnprocessableEntityException();
        }
        if (Student.getCompanyEmail() != null) {
            StudentAct.setCompanyEmail(Student.getCompanyEmail());
        } else {
            throw new UnprocessableEntityException();
        }
        if (Student.getStudentlEmail() != null) {
            StudentAct.setStudentlEmail(Student.getStudentlEmail());
        } else {
            throw new UnprocessableEntityException();
        }
        if (Student.getCity() != null) {
            StudentAct.setCity(Student.getCity());
        } else {
            throw new UnprocessableEntityException();
        }
        if (Student.getActive() != null) {
            StudentAct.setActive(Student.getActive());
        } else {
            throw new UnprocessableEntityException();
        }
        if (Student.getCreatedDate() != null) {
            StudentAct.setCreatedDate(Student.getCreatedDate());
        } else {
            throw new UnprocessableEntityException();
        }
        StudentAct.setImagenUrl(Student.getImagenUrl());
        StudentAct.setTerminationDate(Student.getTerminationDate());
        return StudentRepository.save(StudentAct).StudentToStudentOutputDto();
    }
}