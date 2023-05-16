package com.example.block7crudvalidation_v2.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDtoSimple {
    private int idStudent;
    private int idPerson;
    private Integer hourPerWeek;
    private String comments;
    private String branch;
}