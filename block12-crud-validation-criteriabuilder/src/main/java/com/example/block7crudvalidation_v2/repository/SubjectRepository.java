package com.example.block7crudvalidation_v2.repository;

import com.example.block7crudvalidation_v2.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository <Subject, Integer> {
    Optional<Object> findByName(String name);
}
