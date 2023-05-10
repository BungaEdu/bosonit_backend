package com.example.block7crudvalidation.repository;

import com.example.block7crudvalidation.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Integer> {
    Optional<Object> findByUsuario(String usuario);
}