package com.example.block7crudvalidation.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Table(name = "estudiantes")
@Getter
@Setter
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id_profesor;
    @OneToOne
    @JoinColumn(name = "id_persona")
    Persona persona;
    @Column(name = "comentarios")
    String coments;
    @Column(name = "rama")
    String branch;
}