package com.example.block7crudvalidation_v2.application;

import com.example.block7crudvalidation_v2.controller.PersonController;
import com.example.block7crudvalidation_v2.controller.dto.*;
import com.example.block7crudvalidation_v2.domain.Person;
import com.example.block7crudvalidation_v2.domain.Student;
import com.example.block7crudvalidation_v2.domain.Teacher;
import com.example.block7crudvalidation_v2.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation_v2.repository.PersonRepository;
import com.example.block7crudvalidation_v2.repository.StudentRepository;
import com.example.block7crudvalidation_v2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public PersonOutputDto addPerson(PersonInputDto personInputDto) {
        if (personInputDto.getUsuario() == null || personInputDto.getUsuario().length() < 6 || personInputDto.getUsuario().length() > 10)
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
    public PersonOutputDto getPersonByIdFull(int id) {
        Person person = personRepository.findById(id).orElseThrow();
        if (studentRepository.findByPersonIdPerson(id).isPresent())
            return person.personToPersonStudentOutputDto();
        else if (teacherRepository.findByPersonIdPerson(id).isPresent())
            return person.personToPersonTeacherOutputDto();
        else
            return person.personToPersonOutputDto();
    }

    @Override
    public PersonOutputDto getPersonByIdSimple(int id) {
        return personRepository.findById(id).orElseThrow()
                .personToPersonOutputDto();
    }

    @Override
    public PersonOutputDto getPersonByUsuarioFull(String usuario) {
        Person person = personRepository.findByUsuario(usuario).orElseThrow();
        if (studentRepository.findByPersonUsuario(usuario).isPresent())
            return person.personToPersonStudentOutputDto();
        else if (teacherRepository.findByPersonUsuario(usuario).isPresent())
            return person.personToPersonTeacherOutputDto();
        else
            return person.personToPersonOutputDto();
    }

    @Override
    public PersonOutputDto getPersonByUsuarioSimple(String usuario) {
        return personRepository.findByUsuario(usuario).orElseThrow()
                .personToPersonOutputDto();
    }

    @Override
    public Iterable<PersonOutputDto> getAllPersons(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public List<PersonOutputDto> getAllPersonsFull(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        List<PersonOutputDto> personOutputDtos = new ArrayList<>();
        List<Person> persons = (List<Person>) personRepository.findAll(pageRequest);
        for (Person person : persons) {
            if (studentRepository.findByPersonIdPerson(person.getIdPerson()).isPresent()) {
                personOutputDtos.add(person.personToPersonStudentOutputDto());
            } else if (teacherRepository.findByPersonIdPerson(person.getIdPerson()).isPresent()) {
                personOutputDtos.add(person.personToPersonTeacherOutputDto());
            } else {
                personOutputDtos.add(person.personToPersonOutputDto());
            }
        }
        return personOutputDtos;
    }


    @Override
    public List<PersonOutputDto> getAllPersonsSimple(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return personRepository.findAll(pageRequest).getContent()
                .stream()
                .map(Person::personToPersonOutputDto).toList();
    }

    @Override
    public PersonOutputDto updatePerson(PersonInputDto personInputDto) {
        return personRepository.save(new Person(personInputDto)).personToPersonOutputDto();
    }

    @Override
    public void deletePersonById(int id) {
        personRepository.deleteById(id);
    }

}