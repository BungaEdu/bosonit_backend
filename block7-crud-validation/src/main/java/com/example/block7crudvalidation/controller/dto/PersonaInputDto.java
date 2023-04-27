package com.example.block7crudvalidation.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaInputDto {
    int id;
    //not null max-length:10min-length:6]
    String usuario = "";
    //not null]
    String password;
    //not null]
    String name;
    String surname;
    //not null]
    String companyEmail;
    //not null]
    String personalEmail;
    //not null]
    String city;
    //[not null]
    boolean active;
    //not null]
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    Date createdDate;
    String imagenUrl;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    Date terminationDate;
}