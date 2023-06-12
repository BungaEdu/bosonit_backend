package com.example.block7crudvalidation_v2.dto.output;

import com.example.block7crudvalidation_v2.domain.Person;
import com.example.block7crudvalidation_v2.domain.Subject;
import com.example.block7crudvalidation_v2.domain.Teacher;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDtoFull {
    private int idStudent;
    private int idPerson;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private Boolean active;
    private LocalDate createdDate;
    private String imagenUrl;
    private LocalDate terminationDate;
    private Integer hourPerWeek;
    private String comments;
    private String branch;
    private Set<Subject> subjects;
    private Teacher teacher;
}

