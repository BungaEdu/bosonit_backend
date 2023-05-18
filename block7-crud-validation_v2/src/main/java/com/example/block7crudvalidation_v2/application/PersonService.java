package com.example.block7crudvalidation_v2.application;

import com.example.block7crudvalidation_v2.controller.dto.PersonInputDto;
import com.example.block7crudvalidation_v2.controller.dto.PersonOutputDto;

public interface PersonService {
    PersonOutputDto addPerson(PersonInputDto personInputDto);

    void deletePersonById( int id);

    PersonOutputDto getPersonByIdFull(int id);

    PersonOutputDto getPersonByIdSimple(int id);

    PersonOutputDto getPersonByUsuario(String usuario);

    Iterable<PersonOutputDto> getAllPersons(int pageNumber, int pageSize);
    PersonOutputDto updatePerson(PersonInputDto Person);
}
