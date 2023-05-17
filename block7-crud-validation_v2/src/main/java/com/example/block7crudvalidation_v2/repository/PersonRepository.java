package com.example.block7crudvalidation_v2.repository;

import com.example.block7crudvalidation_v2.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository <Person, Integer> {
    Optional<Person> findByUsuario(String usuario);
}
