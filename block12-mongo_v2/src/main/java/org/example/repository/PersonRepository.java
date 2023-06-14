package org.example.repository;

import org.example.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository <Person, Integer> {
}
