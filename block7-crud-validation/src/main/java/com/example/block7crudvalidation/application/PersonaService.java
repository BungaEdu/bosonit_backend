package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.dto.PersonaInputDto;
import com.example.block7crudvalidation.controller.dto.PersonaOutputDto;

public interface PersonaService {
    PersonaOutputDto addPersona(PersonaInputDto persona);

    PersonaOutputDto getPersonaById(int id);

    void deletePersonaById(int id);

    Iterable<PersonaOutputDto> getAllPersonas(int pageNumber, int pageSize);

    PersonaOutputDto getPersonaByNombre(String nombre);

    PersonaOutputDto updatePersona(PersonaInputDto persona, int id) throws Exception;
}

