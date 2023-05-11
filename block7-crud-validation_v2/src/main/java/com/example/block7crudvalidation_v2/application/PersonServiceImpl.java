package com.example.block7crudvalidation_v2.application;

import com.example.block7crudvalidation_v2.controller.dto.PersonInputDto;
import com.example.block7crudvalidation_v2.controller.dto.PersonOutputDto;
import com.example.block7crudvalidation_v2.domain.Person;
import com.example.block7crudvalidation_v2.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation_v2.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation_v2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonOutputDto addPerson(PersonInputDto personInputDto) {
        if (personInputDto.getUsuario() == null ||  personInputDto.getUsuario().length() < 6 || personInputDto.getUsuario().length() > 10)
            throw new UnprocessableEntityException("UnprocessableEntityException: " +
                    "\n- USUARIO no puede ser nulo" +
                    "\n- Tiene que tener igual o más de 6 dígitos" +
                    "\n- Tiene que tener igual o menos de 10 dígitos");
        if (personInputDto.getPassword() == null)
            throw new UnprocessableEntityException("UnprocessableEntityException: PASSWORD no puede ser nulo");
        if (personInputDto.getName() == null)
            throw new UnprocessableEntityException("UnprocessableEntityException: NOMBRE no puede ser nulo");
        if (personInputDto.getCompanyEmail() == null)
            throw new UnprocessableEntityException("UnprocessableEntityException: COMPANYMAIL no puede ser nulo");
        if (personInputDto.getPersonalEmail() == null)
            throw new UnprocessableEntityException("UnprocessableEntityException: PERSONALMAIL no puede ser nulo");
        if (personInputDto.getCity() == null)
            throw new UnprocessableEntityException("UnprocessableEntityException: CITY no puede ser nulo");
        if (personInputDto.getActive() == null)
            throw new UnprocessableEntityException("UnprocessableEntityException: ACTIVE no puede ser nulo");
        if (personInputDto.getCreatedDate() == null)
            throw new UnprocessableEntityException("UnprocessableEntityException: CREATEDDATE no puede ser nulo");
        return personRepository.save(new Person(personInputDto))
                .personToPersonOutputDto();
    }

    @Override
    public PersonOutputDto getPersonById(int id) {
        return personRepository.findById(id).orElseThrow()
                .personToPersonOutputDto();
    }

    @Override
    public void deletePersonById(int id) {
        if (personRepository.findById(id).isEmpty())
            throw new EntityNotFoundException("La persona con ID: " + id + " no existe");
        personRepository.deleteById(id);
    }

    @Override
    public List<PersonOutputDto> getAllPersons(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return personRepository.findAll(pageRequest).getContent()
                .stream()
                .map(Person::personToPersonOutputDto).toList();
    }

    @Override
    public PersonOutputDto updatePerson(PersonInputDto personInputDto) {
        if (personRepository.findById(personInputDto.getId_person()).isEmpty())
            throw new EntityNotFoundException("EntityNotFoundException: La persona con ID: " + personInputDto.getId_person() + " no existe");
        Person person = new Person(personInputDto);
        return personRepository.save(person).personToPersonOutputDto();
    }
}