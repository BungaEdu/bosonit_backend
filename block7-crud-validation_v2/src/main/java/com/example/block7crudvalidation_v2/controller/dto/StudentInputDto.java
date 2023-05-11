package com.example.block7crudvalidation_v2.controller.dto;

import com.example.block7crudvalidation_v2.domain.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class StudentInputDto {
    Integer id_student;
    Person person;
    Integer hourPerWeek;
    String coments;
    String branch;
}

