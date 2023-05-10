package com.example.block7crudvalidation_v2.domain;

import com.example.block7crudvalidation_v2.controller.dto.PersonInputDto;
import com.example.block7crudvalidation_v2.controller.dto.PersonOutputDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    private int id_person;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private Boolean active;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date createdDate;
    private String imagenUrl;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date terminationDate;

    public Person (PersonInputDto personInputDto) {
        this.id_person=personInputDto.getId_person();
        this.usuario=personInputDto.getUsuario();
        this.password=personInputDto.getPassword();
        this.name=personInputDto.getName();
        this.surname=personInputDto.getSurname();
        this.companyEmail=personInputDto.getCompanyEmail();
        this.personalEmail=personInputDto.getPersonalEmail();
        this.city=personInputDto.getCity();
        this.active=personInputDto.getActive();
        this.createdDate=personInputDto.getCreatedDate();
        this.imagenUrl=personInputDto.getImagenUrl();
        this.terminationDate=personInputDto.getTerminationDate();
    }

    public PersonOutputDto personToPersonOutputDto () {
        return new PersonOutputDto(
                this.id_person,
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
