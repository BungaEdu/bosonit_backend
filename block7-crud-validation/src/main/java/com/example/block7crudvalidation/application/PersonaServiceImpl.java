package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.dto.PersonaInputDto;
import com.example.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.example.block7crudvalidation.domain.Persona;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDto getPersonaById(int id) {
        return personaRepository.findById(id).orElseThrow()
                .personaToPersonaOutputDto();
    }

    @Override
    public Iterable<PersonaOutputDto> getAllPersonas(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return personaRepository.findAll(pageRequest).getContent()
                .stream()
                .map(Persona::personaToPersonaOutputDto).toList();
    }

    @Override
    public void deletePersonaById(int id) {
        personaRepository.findById(id).orElseThrow();
        personaRepository.deleteById(id);
    }

    @Override
    public PersonaOutputDto getPersonaByUsuario(String usuario) {
        return (PersonaOutputDto) personaRepository.findByUsuario(usuario).orElseThrow();
    }

    @Override
    public PersonaOutputDto addPersona(PersonaInputDto persona) throws EntityNotFoundException, UnprocessableEntityException {
        if (persona.getUsuario() == null || persona.getUsuario().length() < 6 || persona.getUsuario().length() > 10) {
            throw new UnprocessableEntityException();
        }
        if (persona.getPassword() == null) {
            throw new UnprocessableEntityException();
        }
        if (persona.getName() == null) {
            throw new UnprocessableEntityException();
        }
        if (persona.getCompanyEmail() == null) {
            throw new UnprocessableEntityException();
        }
        if (persona.getPersonalEmail() == null) {
            throw new UnprocessableEntityException();
        }
        if (persona.getCity() == null) {
            throw new UnprocessableEntityException();
        }
        if (persona.getActive() == null) {
            throw new UnprocessableEntityException();
        }
        if (persona.getCreatedDate() == null) {
            throw new UnprocessableEntityException();
        }
        return personaRepository.save(new Persona(persona)).personaToPersonaOutputDto();
    }

    @Override
    public PersonaOutputDto updatePersona(PersonaInputDto persona, int id) throws EntityNotFoundException, UnprocessableEntityException {
        Persona personaAct = personaRepository.findById(id).orElseThrow();
        if (persona.getUsuario() != null || persona.getUsuario().length() >= 6 || persona.getUsuario().length() <= 10) {
            personaAct.setUsuario(persona.getUsuario());
        } else {
            throw new UnprocessableEntityException();
        }
        if (persona.getPassword() != null) {
            personaAct.setPassword(persona.getPassword());
        } else {
            throw new UnprocessableEntityException();
        }
        if (persona.getName() != null) {
            personaAct.setName(persona.getName());
        } else {
            throw new UnprocessableEntityException();
        }
        if (persona.getCompanyEmail() != null) {
            personaAct.setCompanyEmail(persona.getCompanyEmail());
        } else {
            throw new UnprocessableEntityException();
        }
        if (persona.getPersonalEmail() != null) {
            personaAct.setPersonalEmail(persona.getPersonalEmail());
        } else {
            throw new UnprocessableEntityException();
        }
        if (persona.getCity() != null) {
            personaAct.setCity(persona.getCity());
        } else {
            throw new UnprocessableEntityException();
        }
        if (persona.getActive() != null) {
            personaAct.setActive(persona.getActive());
        } else {
            throw new UnprocessableEntityException();
        }
        if (persona.getCreatedDate() != null) {
            personaAct.setCreatedDate(persona.getCreatedDate());
        } else {
            throw new UnprocessableEntityException();
        }
        personaAct.setImagenUrl(persona.getImagenUrl());
        personaAct.setTerminationDate(persona.getTerminationDate());
        return personaRepository.save(personaAct).personaToPersonaOutputDto();
    }
}