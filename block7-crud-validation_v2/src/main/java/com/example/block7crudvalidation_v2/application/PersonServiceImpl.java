package com.example.block7crudvalidation_v2.application;

import com.example.block7crudvalidation_v2.controller.dto.PersonInputDto;
import com.example.block7crudvalidation_v2.controller.dto.PersonOutputDto;
import com.example.block7crudvalidation_v2.domain.Person;
import com.example.block7crudvalidation_v2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonOutputDto addPerson(PersonInputDto personInputDto) {

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
        personRepository.findById(id).orElseThrow();
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
        personRepository.findById(personInputDto.getId_person()).orElseThrow();
        return personRepository.save(new Person(personInputDto))
                .personToPersonOutputDto();
    }
}