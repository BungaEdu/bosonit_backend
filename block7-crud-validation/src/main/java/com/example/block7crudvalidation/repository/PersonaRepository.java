package com.example.block7crudvalidation.repository;

import com.example.block7crudvalidation.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona,Integer> {
    Optional<Object> findByUsuario(String usuario);
}