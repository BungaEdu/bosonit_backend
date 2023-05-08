package com.example.block7crudvalidation.repository;

import com.example.block7crudvalidation.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {
/*
    Optional<Object> findByUsuario(String usuario);
*/
}
