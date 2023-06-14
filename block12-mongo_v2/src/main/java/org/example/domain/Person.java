package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.controller.dto.PersonInputDto;
import org.example.controller.dto.PersonOutputDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDate;

@Document(collection = "Person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    private String idPerson;
    private String name;
    private String surname;
    private boolean active;
    private LocalDate createdDate;

    public Person(PersonInputDto person) {
        this.idPerson = person.getIdPersona();
        this.name = person.getName();
        this.surname = person.getSurname();
        this.active = person.isActive();
        this.createdDate = person.getCreatedDate();
    }

    public PersonOutputDto personToPersonOutputDto() {
        return new PersonOutputDto(
                this.idPerson,
                this.name,
                this.surname,
                this.active,
                this.createdDate);
    }
}