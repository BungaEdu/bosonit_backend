package com.example.block7crudvalidation.domain;

import com.example.block7crudvalidation.controller.dto.PersonaInputDto;
import com.example.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue
    private int id;
    //not null max-length:10min-length:6]
    private String usuario;
    //not null]
    private String password;
    //not null]
    private String name;
    private String surname;
    //not null]
    private String companyEmail;
    //not null]
    private String personalEmail;
    //not null]
    private String city;
    //[not null]
    private Boolean active;
    //not null]
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date createdDate;
    private String imagenUrl;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date terminationDate;

    public Persona(PersonaInputDto personaInputDto) {
        this.id = personaInputDto.getId();
        this.usuario = personaInputDto.getUsuario();
        this.password = personaInputDto.getPassword();
        this.name = personaInputDto.getName();
        this.surname = personaInputDto.getSurname();
        this.companyEmail = personaInputDto.getCompanyEmail();
        this.personalEmail = personaInputDto.getPersonalEmail();
        this.city = personaInputDto.getCity();
        this.active = personaInputDto.getActive();
        this.createdDate = personaInputDto.getCreatedDate();
        this.imagenUrl = personaInputDto.getImagenUrl();
        this.terminationDate = personaInputDto.getTerminationDate();
    }

    public PersonaOutputDto personaToPersonaOutputDto() {
        return new PersonaOutputDto(
                this.id,
                this.usuario,
                this.password,
                this.name,
                this.surname,
                this.companyEmail,
                this.personalEmail,
                this.city,
                this.active,
                this.createdDate,
                this.imagenUrl,
                this.terminationDate
        );
    }
}
