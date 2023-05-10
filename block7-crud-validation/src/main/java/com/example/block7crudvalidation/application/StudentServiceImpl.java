package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.dto.StudentInputDto;
import com.example.block7crudvalidation.controller.dto.StudentOutputDto;
import com.example.block7crudvalidation.domain.Student;
import com.example.block7crudvalidation.exceptions.CustomError;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentOutputDto getStudentById(int id) {
        return studentRepository.findById(id).orElseThrow()
                .studentToStudentOutputDto();
    }

    //aquí tengo que poner el
    @Override
    public List<StudentOutputDto> getAllStudents(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return studentRepository.findAll(pageRequest).getContent()
                .stream()
                .map(Student::studentToStudentOutputDto).toList();
    }

    @Override
    public StudentOutputDto getStudentByUsuario(String usuario) {
        return null;
    }
/*
    @Override
    public void deleteStudentById(int id) {
        studentRepository.findById(id).orElseThrow();
        studentRepository.deleteById(id);
    }

    @Override
    public Iterable<StudentOutputDto> getAllStudents(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public StudentOutputDto getStudentByUsuario(String usuario) {
        return null;
    }

/*    @Override
    public StudentOutputDto getStudentByUsuario(String usuario) {
        return (StudentOutputDto) studentRepository.findByUsuario(usuario).orElseThrow();
    }*/

    @Override
    public StudentOutputDto updateStudent(StudentInputDto Student, int id) throws EntityNotFoundException, UnprocessableEntityException {
        return null;
    }

    @Override
    public StudentOutputDto addStudent(StudentInputDto student) throws EntityNotFoundException, UnprocessableEntityException {
        /*if (student.getPersona().getUsuario() == null || student.getPersona().getUsuario().length() < 6 || student.getPersona().getUsuario().length() > 10) {
            throw new UnprocessableEntityException().getError("Error campo usuario");
        }
        if (student.getPersona().getPassword() == null) {
            throw new UnprocessableEntityException().getError("Error campo password");
        }
        if (student.getPersona().getName() == null) {
            throw new UnprocessableEntityException().getError("Error campo Name");
        }
        if (student.getPersona().getCompanyEmail() == null) {
            throw new UnprocessableEntityException().getError("Error campo CompanyEmail");
        }
        if (student.getPersona().getPersonalEmail() == null) {
            throw new UnprocessableEntityException().getError("Error campo PersonalEmail");
        }
        if (student.getPersona().getCity() == null) {
            throw new UnprocessableEntityException().getError("Error campo City");
        }
        if (student.getPersona().getActive() == null) {
            throw new UnprocessableEntityException();
        }
        if (student.getPersona().getCreatedDate() == null) {
            throw new UnprocessableEntityException().getError("Error campo CreatedDate");
        }*/
        return studentRepository.save(new Student(student)).studentToStudentOutputDto();
    }

    @Override
    public void deleteStudentById(int id) {

    }
/*
    @Override
    public StudentOutputDto updateStudent(StudentInputDto Student, int id) throws EntityNotFoundException, UnprocessableEntityException {
        Student StudentAct = studentRepository.findById(id).orElseThrow();
        if (Student.getPersona().getUsuario() != null || Student.getUsuario().length() >= 6 || Student.getUsuario().length() <= 10) {
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
        return studentRepository.save(StudentAct).StudentToStudentOutputDto();
    }*/
}