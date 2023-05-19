package com.example.block7crudvalidation_v2.application;

import com.example.block7crudvalidation_v2.domain.Student;
import com.example.block7crudvalidation_v2.domain.Subject;
import com.example.block7crudvalidation_v2.dto.input.SubjectInputDto;
import com.example.block7crudvalidation_v2.dto.output.SubjectOutputDto;
import com.example.block7crudvalidation_v2.repository.StudentRepository;
import com.example.block7crudvalidation_v2.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public SubjectOutputDto addSubject(SubjectInputDto SubjectInputDto) {
        return subjectRepository.save(new Subject(SubjectInputDto))
                .subjectToSubjectOutputDto();
    }

    @Override
    public SubjectOutputDto getSubjectById(int id) {
        return subjectRepository.findById(id).orElseThrow()
                .subjectToSubjectOutputDto();
    }

    @Override
    public List<SubjectOutputDto> getAllSubjects(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return subjectRepository.findAll(pageRequest).getContent()
                .stream()
                .map(Subject::subjectToSubjectOutputDto).toList();
    }

    @Override
    public SubjectOutputDto updateSubject(SubjectInputDto SubjectInputDto) {
        return subjectRepository.save(new Subject(SubjectInputDto)).subjectToSubjectOutputDto();
    }

    @Override
    public void deleteSubjectById(int id) {
        subjectRepository.deleteById(id);
    }
}
