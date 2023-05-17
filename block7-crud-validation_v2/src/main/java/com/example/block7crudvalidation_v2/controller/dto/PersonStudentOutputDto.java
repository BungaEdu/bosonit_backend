package com.example.block7crudvalidation_v2.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PersonStudentOutputDto {
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date createdDate;
    private String imagenUrl;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date terminationDate;
    private Integer hourPerWeek;
    private String comments;
    private String branch;
}
