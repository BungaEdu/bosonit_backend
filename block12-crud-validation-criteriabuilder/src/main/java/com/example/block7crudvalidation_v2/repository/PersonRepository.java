package com.example.block7crudvalidation_v2.repository;

import com.example.block7crudvalidation_v2.domain.Person;
import com.example.block7crudvalidation_v2.dto.output.PersonOutputDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository <Person, Integer> {
    Optional<Person> findByUsuario(String usuario);

    Iterable<PersonOutputDto> getCustomQuery(HashMap<String, Object> data, String order, int pageNumber, int pageSize);
}
