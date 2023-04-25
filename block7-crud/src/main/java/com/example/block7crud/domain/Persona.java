package com.example.block7crud.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    //@GeneratedValue
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nombre;
    int edad;
    String poblacion;
}

