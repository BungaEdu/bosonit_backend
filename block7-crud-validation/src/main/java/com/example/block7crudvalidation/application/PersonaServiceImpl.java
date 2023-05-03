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
    public PersonaOutputDto addPersona(PersonaInputDto persona) throws Exception {
        if (persona.getUsuario() == null || persona.getUsuario().length() < 6 || persona.getUsuario().length() > 10) {
            throw new Exception("Usuario introducido erróneo, no cumple las condiciones");
        }
        if (persona.getPassword() == null) {
            throw new Exception("Usuario erróneo, el campo Password no puede ser nulo");
        }
        if (persona.getName() == null) {
            throw new Exception("Usuario erróneo, el campo Name no puede ser nulo");
        }
        if (persona.getCompanyEmail() == null) {
            throw new Exception("Usuario erróneo, el campo Company Email no puede ser nulo");
        }
        if (persona.getPersonalEmail() == null) {
            throw new Exception("Usuario erróneo, el campo Personal Email no puede ser nulo");
        }
        if (persona.getCity() == null) {
            throw new Exception("Usuario erróneo, el campo City no puede ser nulo");
        }
        if (persona.getActive() == null) {
            throw new Exception("Usuario erróneo, el campo Active no puede ser nulo");
        }
        if (persona.getCreatedDate() == null) {
            throw new Exception("Usuario erróneo, el campo Created Date no puede ser nulo");
        }
        return personaRepository.save(new Persona(persona)).personaToPersonaOutputDto();
    }

    @Override
    public PersonaOutputDto updatePersona(PersonaInputDto persona, int id) throws Exception {
        Persona personaAct = personaRepository.findById(id).orElseThrow();
        if (persona.getUsuario() != null || persona.getUsuario().length() >= 6 || persona.getUsuario().length() >= 10) {
            personaAct.setUsuario(persona.getUsuario());
        } else {
            throw new Exception("Usuario introducido erróneo, no cumple las condiciones");
        }
        if (persona.getPassword() != null) {
            personaAct.setPassword(persona.getPassword());
        } else {
            throw new Exception("Usuario introducido erróneo, el campo Password no puede ser nulo");
        }
        if (persona.getName() != null) {
            personaAct.setName(persona.getName());
        } else {
            throw new Exception("Usuario introducido erróneo, el campo Name no puede ser nulo");
        }
        if (persona.getCompanyEmail() != null) {
            personaAct.setCompanyEmail(persona.getCompanyEmail());
        } else {
            throw new Exception("Usuario introducido erróneo, el campo Company Email no puede ser nulo");
        }
        if (persona.getPersonalEmail() != null) {
            personaAct.setPersonalEmail(persona.getPersonalEmail());
        } else {
            throw new Exception("Usuario introducido erróneo, el campo Personal Email no puede ser nulo");
        }
        if (persona.getCity() != null) {
            personaAct.setCity(persona.getCity());
        } else {
            throw new Exception("Usuario introducido erróneo, el campo City no puede ser nulo");
        }
        if (persona.getActive() != null) {
            personaAct.setActive(persona.getActive());
        } else {
            throw new Exception("Usuario introducido erróneo, el campo Active no puede ser nulo");
        }
        if (persona.getCreatedDate() != null) {
            personaAct.setCreatedDate(persona.getCreatedDate());
        } else {
            throw new Exception("Usuario introducido erróneo, el campo Created Date no puede ser nulo");
        }
        personaAct.setImagenUrl(persona.getImagenUrl());
        personaAct.setTerminationDate(persona.getTerminationDate());
        return personaRepository.save(personaAct).personaToPersonaOutputDto();
    }
}