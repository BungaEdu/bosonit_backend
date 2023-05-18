package com.example.block7crudvalidation_v2.repository;

import com.example.block7crudvalidation_v2.domain.Person;
import com.example.block7crudvalidation_v2.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository <Student, Integer> {
    Optional<Student> findByPersonIdPerson(int idPerson);
    Optional<Object> findByPersonUsuario(String usuario);
}
