/*
package com.example.block7crudvalidation.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
@Table(name = "estudios")
@Getter
@Setter
public class StudentAsignatura {
    @Id
    @GeneratedValue
    Integer id_study;
*/
/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id")
    Profesor profesor;*//*

    @ManyToMany(cascade = CascadeType.ALL)
    Student student;
    @Column(name = "asignatura")
    String asignatura;
    @Column(name = "comentarios")
    String comment;
    @Column(name = "initial_date")
    Date initial_date;
    @Column(name = "finish_date")
    Date finish_date;
}*/
