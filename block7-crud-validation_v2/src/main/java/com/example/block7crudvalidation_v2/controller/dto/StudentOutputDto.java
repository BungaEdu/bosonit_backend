package com.example.block7crudvalidation_v2.controller.dto;

import com.example.block7crudvalidation_v2.domain.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDto {
    private Integer id_student;
    private Integer hourPerWeek;
    private String coments;
    private String branch;
}

