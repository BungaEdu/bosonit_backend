package com.example.block7crudvalidation_v2.domain;

import com.example.block7crudvalidation_v2.controller.dto.PersonInputDto;
import com.example.block7crudvalidation_v2.controller.dto.PersonOutputDto;
import com.example.block7crudvalidation_v2.controller.dto.PersonStudentOutputDto;
import com.example.block7crudvalidation_v2.controller.dto.StudentOutputDtoSimple;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
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
    @Column(name = "id_person")
    private int idPerson;
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
    @OneToOne(
            mappedBy = "person",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Student student;
    @OneToOne(
            mappedBy = "person",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Teacher teacher;

    public Person (PersonInputDto personInputDto) {
        this.idPerson =personInputDto.getIdPerson();
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
                this.idPerson,
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

    public PersonStudentOutputDto personToPersonStudentOutputDto () {
        StudentOutputDtoSimple student = this.student.studentToStudentOutputDtoSimple();
        return new PersonStudentOutputDto(
                student.getIdStudent(),
                this.idPerson,
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
                this.terminationDate,
                student.getHourPerWeek(),
                student.getComments(),
                student.getBranch()
        );
    }

}
