package com.example.block7crudvalidation.controller.dto;


import com.example.block7crudvalidation.domain.Persona;
/*
import com.example.block7crudvalidation.domain.Profesor;
*/
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentInputDto {
    private Integer id_student;
    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
    private Integer num_hours_week;
    private String coments;
/*
    private Profesor profesor;
*/
    private String branch;
}
