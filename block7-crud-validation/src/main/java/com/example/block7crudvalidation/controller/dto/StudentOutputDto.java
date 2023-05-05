package com.example.block7crudvalidation.controller.dto;


import com.example.block7crudvalidation.domain.Persona;
import com.example.block7crudvalidation.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDto {
    private Integer id_student;
    private Persona persona;
    private Integer num_hours_week;
    private String coments;
    private Profesor profesor;
    private String branch;
}