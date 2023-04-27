package com.example.block7crud.repository;

import com.example.block7crud.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona,Integer> {

    Optional<Persona> findByNombre(String nombre);
}