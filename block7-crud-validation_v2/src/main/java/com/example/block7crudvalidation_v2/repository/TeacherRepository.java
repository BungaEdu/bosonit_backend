package com.example.block7crudvalidation_v2.repository;

import com.example.block7crudvalidation_v2.domain.Student;
import com.example.block7crudvalidation_v2.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository <Teacher, Integer> {
    Optional<Object> findByPersonIdPerson(int idPerson);
}
