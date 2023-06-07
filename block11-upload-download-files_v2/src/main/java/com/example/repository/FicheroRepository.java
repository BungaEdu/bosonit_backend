package com.example.repository;

import com.example.domain.Fichero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FicheroRepository extends JpaRepository<Fichero, Integer> {
    Fichero[] findByName(String nombreFichero);
}