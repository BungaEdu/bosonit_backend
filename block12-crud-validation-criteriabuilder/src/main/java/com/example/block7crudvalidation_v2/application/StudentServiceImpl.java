package com.example.block7crudvalidation_v2.application;

import com.example.block7crudvalidation_v2.domain.Subject;
import com.example.block7crudvalidation_v2.dto.input.StudentInputDto;
import com.example.block7crudvalidation_v2.dto.output.StudentOutputDtoFull;
import com.example.block7crudvalidation_v2.dto.output.StudentOutputDtoSimple;
import com.example.block7crudvalidation_v2.domain.Student;
import com.example.block7crudvalidation_v2.repository.StudentRepository;
import com.example.block7crudvalidation_v2.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public StudentOutputDtoSimple addStudent(StudentInputDto studentInputDto) {
        return studentRepository.save(new Student(studentInputDto))
                .studentToStudentOutputDtoSimple();
    }

    @Override
    public StudentOutputDtoSimple addSubjectToStudent(int id, List<Integer> idList) {

        Subject subject;
        Set<Subject> estudiosList = new HashSet<>();
        for (Integer i : idList) {
            subject = subjectRepository.findById(i).orElseThrow();
            estudiosList.add(subject);
        }
        Student student = studentRepository.findById(id).orElseThrow();
        student.setSubjects(estudiosList);
        return studentRepository.save(student)
                .studentToStudentOutputDtoSimple();
    }
    @Override
    public StudentOutputDtoSimple removeSubjectsToStudent(int id, List<Integer> idList) {
        Subject subject;
        Set<Subject> estudiosList = new HashSet<>();
        for (Integer i : idList) {
            subject = subjectRepository.findById(i).orElseThrow();
            estudiosList.add(subject);
        }
        Student student = studentRepository.findById(id).orElseThrow();
        Set<Subject> subjectsStudent = student.getSubjects();
        Set<Subject> subjectsToAdd = new HashSet<>();
        for (Subject x : estudiosList) {
            for (Subject y : subjectsStudent) {
                if (x.getIdSubject() == y.getIdSubject())
                    subjectsToAdd.add(x);
            }
        }
        subjectsStudent.removeAll(subjectsToAdd);
        student.setSubjects(subjectsStudent);
        return studentRepository.save(student)
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
