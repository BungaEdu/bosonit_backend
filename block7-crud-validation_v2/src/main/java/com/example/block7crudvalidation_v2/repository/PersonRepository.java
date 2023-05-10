package com.example.block7crudvalidation_v2.repository;

import com.example.block7crudvalidation_v2.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository <Person, Integer> {

}
