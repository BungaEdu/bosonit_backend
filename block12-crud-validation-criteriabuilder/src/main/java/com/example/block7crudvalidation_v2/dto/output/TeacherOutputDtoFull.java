package com.example.block7crudvalidation_v2.dto.output;

import com.example.block7crudvalidation_v2.domain.Student;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherOutputDtoFull {
    private int idTeacher;
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
    private String comments;
    private String branch;
    private List<Student> students;
}
