package org.example.repository;

import org.example.domain.Fichero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Fichero, Integer> {
}