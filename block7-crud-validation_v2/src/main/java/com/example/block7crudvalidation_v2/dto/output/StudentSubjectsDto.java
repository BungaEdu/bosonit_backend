package com.example.block7crudvalidation_v2.dto.output;

import com.example.block7crudvalidation_v2.domain.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSubjectsDto extends StudentOutputDtoSimple{
    private int idStudent;
    private int idPerson;
    Integer hourPerWeek;
    private String comments;
    private String branch;
    private List<Subject> subjects;
}