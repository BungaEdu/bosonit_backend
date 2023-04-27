package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.dto.PersonaInputDto;
import com.example.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.example.block7crudvalidation.domain.Persona;
import com.example.block7crudvalidation.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDto addPersona(PersonaInputDto persona) {
        return personaRepository.save(new Persona(persona)).personaToPersonaOutputDto();
    }

    @Override
    public PersonaOutputDto getPersonaById(int id) {
        return personaRepository.findById(id).orElseThrow()
                .personaToPersonaOutputDto();
    }

    @Override
    public PersonaOutputDto getPersonaByNombre(String nombre) {
        return (PersonaOutputDto) personaRepository.findByUsuario(nombre).orElseThrow();
    }


    @Override
    public void deletePersonaById(int id) {
        personaRepository.findById(id).orElseThrow();
        personaRepository.deleteById(id);
    }

    @Override
    public Iterable<PersonaOutputDto> getAllPersonas(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return personaRepository.findAll(pageRequest).getContent()
                .stream()
                .map(Persona::personaToPersonaOutputDto).toList();
    }

    @Override
    public PersonaOutputDto updatePersona(PersonaInputDto persona, int id) {
        Persona personaAct = personaRepository.findById(id).orElseThrow();
        if (persona.getUsuario() != null) {
            personaAct.setUsuario(persona.getUsuario());
        }
        if (persona.getName() != null) {
            personaAct.setName(persona.getName());
        }
        if (persona.getSurname() != null) {
            personaAct.setSurname(persona.getSurname());
        }
        return personaRepository.save(personaAct).personaToPersonaOutputDto();
    }

}