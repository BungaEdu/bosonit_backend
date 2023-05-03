package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.dto.PersonaInputDto;
import com.example.block7crudvalidation.controller.dto.PersonaOutputDto;

public interface PersonaService {
    PersonaOutputDto addPersona(PersonaInputDto persona) throws Exception;

    PersonaOutputDto getPersonaById(int id);

    void deletePersonaById(int id);

    Iterable<PersonaOutputDto> getAllPersonas(int pageNumber, int pageSize);

    PersonaOutputDto getPersonaByUsuario(String usuario);

    PersonaOutputDto updatePersona(PersonaInputDto persona, int id) throws Exception;
}

