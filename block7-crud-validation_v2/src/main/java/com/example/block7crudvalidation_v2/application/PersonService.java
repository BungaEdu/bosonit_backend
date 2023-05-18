package com.example.block7crudvalidation_v2.application;

import com.example.block7crudvalidation_v2.dto.input.PersonInputDto;
import com.example.block7crudvalidation_v2.dto.output.PersonOutputDto;

import java.util.List;

public interface PersonService {
    PersonOutputDto addPerson(PersonInputDto personInputDto);

    void deletePersonById( int id);

    PersonOutputDto getPersonByIdFull(int id);

    PersonOutputDto getPersonByIdSimple(int id);

    PersonOutputDto getPersonByUsuarioFull(String usuario);

    PersonOutputDto getPersonByUsuarioSimple(String usuario);
    List<PersonOutputDto> getAllPersonsFull(int pageNumber, int pageSize);

    List<PersonOutputDto> getAllPersonsSimple(int pageNumber, int pageSize);

    PersonOutputDto updatePerson(PersonInputDto Person);
}
