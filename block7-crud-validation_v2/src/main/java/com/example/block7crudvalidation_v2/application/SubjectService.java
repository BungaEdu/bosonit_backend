package com.example.block7crudvalidation_v2.application;

import com.example.block7crudvalidation_v2.dto.input.SubjectInputDto;
import com.example.block7crudvalidation_v2.dto.output.SubjectOutputDto;
import com.example.block7crudvalidation_v2.dto.output.SubjectOutputDto;

import java.util.List;

public interface SubjectService {
    SubjectOutputDto addSubject(SubjectInputDto SubjectInputDto);
    SubjectOutputDto getSubjectById(int id);
    void deleteSubjectById( int id);
    List<SubjectOutputDto> getAllSubjects(int pageNumber, int pageSize);
    SubjectOutputDto updateSubject(SubjectInputDto Subject);
}
