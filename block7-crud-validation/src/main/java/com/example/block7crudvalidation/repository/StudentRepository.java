package com.example.block7crudvalidation.repository;

import com.example.block7crudvalidation.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
