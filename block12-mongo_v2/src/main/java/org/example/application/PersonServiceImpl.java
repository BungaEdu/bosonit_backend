package org.example.application;

import org.example.controller.dto.PersonInputDto;
import org.example.controller.dto.PersonOutputDto;
import org.example.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public PersonOutputDto addPerson(PersonInputDto personInputDto) {
        return mongoTemplate.save(new Person(personInputDto))
                .personToPersonOutputDto();
    }

    @Override
    public List<Person> getAllPerson() {
        return mongoTemplate.findAll(Person.class);
    }

    @Override
    public List<Person> getAllPersonPaginated(int pageNumber, int pageSize) {
        Query query = new Query();
        query.skip(pageNumber * pageSize);
        query.limit(pageSize);
        return mongoTemplate.find(query, Person.class);
    }

    @Override
    public List<Person> findByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.find(query, Person.class);
    }

    @Override
    public Person updateOnePerson(Person person, String id) {
        person.setIdPerson(id);
        return mongoTemplate.save(person);
    }

//    @Override
//    public void deletePerson(Person person) {
//        Optional<Person> personaOptional = Optional.ofNullable(mongoTemplate.findById(person.getIdPerson(), Person.class));
//        personaOptional.ifPresent(persona -> mongoTemplate.remove(persona));
//    }

    @Override
    public Person getPersonById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Person.class);
    }

}