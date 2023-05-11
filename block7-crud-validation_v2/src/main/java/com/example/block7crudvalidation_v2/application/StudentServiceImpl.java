package com.example.block7crudvalidation_v2.application;

import com.example.block7crudvalidation_v2.controller.dto.StudentInputDto;
import com.example.block7crudvalidation_v2.controller.dto.StudentOutputDto;
import com.example.block7crudvalidation_v2.domain.Student;
import com.example.block7crudvalidation_v2.exceptions.UnprocessableEntityException;
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
        if (studentInputDto.getUsuario() == null ||  studentInputDto.getUsuario().length() < 6 || studentInputDto.getUsuario().length() > 10)
            throw new UnprocessableEntityException("UnprocessableEntityException: " +
                    "\n- USUARIO no puede ser nulo" +
                    "\n- Tiene que tener igual o más de 6 dígitos" +
                    "\n- Tiene que tener igual o menos de 10 dígitos");
        if (studentInputDto.getPassword() == null)
            throw new UnprocessableEntityException("UnprocessableEntityException: PASSWORD no puede ser nulo");
        if (studentInputDto.getName() == null)
            throw new UnprocessableEntityException("UnprocessableEntityException: NOMBRE no puede ser nulo");
        if (studentInputDto.getCompanyEmail() == null)
            throw new UnprocessableEntityException("UnprocessableEntityException: COMPANYMAIL no puede ser nulo");
        if (studentInputDto.getStudentalEmail() == null)
            throw new UnprocessableEntityException("UnprocessableEntityException: studentALMAIL no puede ser nulo");
        if (studentInputDto.getCity() == null)
            throw new UnprocessableEntityException("UnprocessableEntityException: CITY no puede ser nulo");
        if (studentInputDto.getActive() == null)
            throw new UnprocessableEntityException("UnprocessableEntityException: ACTIVE no puede ser nulo");
        if (studentInputDto.getCreatedDate() == null)
            throw new UnprocessableEntityException("UnprocessableEntityException: CREATEDDATE no puede ser nulo");
        return studentRepository.save(new Student(studentInputDto))
                .studentToStudentOutputDto();
    }

    @Override
    public StudentOutputDto getStudentById(int id) {
        return studentRepository.findById(id).orElseThrow()
                .studentToStudentOutputDto();
    }

    @Override
    public List<StudentOutputDto> getAllStudents(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return studentRepository.findAll(pageRequest).getContent()
                .stream()
                .map(Student::studentToStudentOutputDto).toList();
    }

    @Override
    public StudentOutputDto updateStudent(StudentInputDto studentInputDto) {
        return studentRepository.save(new Student(studentInputDto)).studentToStudentOutputDto();
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }
}