package com.example.block7crudvalidation_v2.controller.dto;

import com.example.block7crudvalidation_v2.domain.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInputDto {
    int idStudent;
    int idPerson;
    Integer hourPerWeek;
    String comments;
    String branch;
}

