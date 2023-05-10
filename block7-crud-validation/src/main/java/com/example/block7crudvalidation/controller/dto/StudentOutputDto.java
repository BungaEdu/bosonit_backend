package com.example.block7crudvalidation.controller.dto;

import com.example.block7crudvalidation.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDto {
    private int id_student;
    private Persona persona;
    private Integer num_hours_week;
    private String coments;
    private String branch;
    }
