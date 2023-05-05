package com.example.block7crudvalidation.domain;


import com.example.block7crudvalidation.controller.dto.PersonaInputDto;
import com.example.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.example.block7crudvalidation.controller.dto.StudentInputDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Table(name = "estudiantes")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id_student;
    @OneToOne
    @JoinColumn(name = "id_persona")
    Persona persona;
    @Column(name = "horas_por_semana")
    Integer num_hours_week;
    @Column(name = "comentarios")
    String coments;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    Profesor profesor;
    @Column(name = "rama")
    String branch;
    /*@OneToMany
    List<StudentAsignatura> estudios;*/

    public Student(StudentInputDto studentInputDto) {
        this.id_student = studentInputDto.id_student();
        this.persona = studentInputDto.persona();
        this.num_hours_week = studentInputDto.num_hours_week();
        this.coments = studentInputDto.coments();
        this.profesor = studentInputDto.profesor();
        this.branch = studentInputDto.branch();
    }

    public PersonaOutputDto personaToPersonaOutputDto() {
        return new PersonaOutputDto(
                this.id,
                this.usuario,
                this.password,
                this.name,
                this.surname,
                this.companyEmail,
                this.personalEmail,
                this.city,
                this.active,
                this.createdDate,
                this.imagenUrl,
                this.terminationDate
        );
    }
}

