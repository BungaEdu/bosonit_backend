package com.example.block7crud.application;

import com.example.block7crud.controller.dto.PersonaInputDto;
import com.example.block7crud.controller.dto.PersonaOutputDto;
import com.example.block7crud.domain.Persona;
import com.example.block7crud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService{
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
        return personaRepository.findByNombre(nombre).orElseThrow()
                .personaToPersonaOutputDto();
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
    public PersonaOutputDto updatePersona(PersonaInputDto persona,int id) {
        Persona personaAct = personaRepository.findById(id).orElseThrow();
        if (persona.getNombre() != null) {
            personaAct.setNombre(persona.getNombre());
        }
        if (persona.getEdad() != 0) {
            personaAct.setEdad(persona.getEdad());
        }
        if (persona.getPoblacion() != null) {
            personaAct.setPoblacion(persona.getPoblacion());
        }
        return personaRepository.save(personaAct).personaToPersonaOutputDto();
    }

}