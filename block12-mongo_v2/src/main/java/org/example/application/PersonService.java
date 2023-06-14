package org.example.application;

import org.example.controller.dto.PersonInputDto;
import org.example.controller.dto.PersonOutputDto;
import org.example.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    PersonOutputDto addPerson(PersonInputDto personInputDto);

    List<Person> getAllPerson();
    List<Person> getAllPersonPaginated(
            int pageNumber, int pageSize);
    List<Person> findByName(String name);
    Person updateOnePerson(Person person,String id);
    void deletePersonById(Person person);

    //    void deletePerson(Person person);
    Person getPersonById(String id);

    Person getPersonByName(String name);
}