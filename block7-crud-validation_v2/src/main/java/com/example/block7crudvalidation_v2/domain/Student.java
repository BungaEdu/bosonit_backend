package com.example.block7crudvalidation_v2.domain;

import com.example.block7crudvalidation_v2.controller.dto.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "id_student")
    private int idStudent;
    @OneToOne
    @JoinColumn(name = "id_person")
    private Person person;
    private Integer hourPerWeek;
    private String comments;
    private String branch;

    public Student(StudentInputDto studentInputDto) {
        this.idStudent = studentInputDto.getIdStudent();
        this.hourPerWeek = studentInputDto.getHourPerWeek();
        this.comments = studentInputDto.getComments();
        this.branch = studentInputDto.getBranch();
    }

    public StudentOutputDto studentToStudentOutputDto(StudentInputDto studentInputDto) {
        return new StudentOutputDto(
                this.idStudent,
                studentInputDto.getIdPerson(),
                this.hourPerWeek = studentInputDto.getHourPerWeek(),
                this.comments = studentInputDto.getComments(),
                this.branch = studentInputDto.getBranch()
        );
    }

    public StudentOutputDtoSimple studentToStudentOutputDtoSimple() {
        return new StudentOutputDtoSimple(
                this.idStudent,
                this.person.getIdPerson(),
                this.hourPerWeek,
                this.comments,
                this.branch
        );
    }

    public StudentOutputDtoFull studentToStudentOutputDtoFull() {
        Person person = new Person();
        return new StudentOutputDtoFull(
                this.idStudent,
                person.getIdPerson(),
                person.getUsuario(),
                person.getPassword(),
                person.getName(),
                person.getSurname(),
                person.getCompanyEmail(),
                person.getPersonalEmail(),
                person.getCity(),
                person.getActive(),
                person.getCreatedDate(),
                person.getImagenUrl(),
                person.getTerminationDate(),
                this.hourPerWeek,
                this.comments,
                this.branch
        );
    }

}

























                /*this.person.getIdPerson(),
                this.person.getUsuario(),
                this.person.getPassword(),
                this.person.getName(),
                this.person.getSurname(),
                this.person.getCompanyEmail(),
                this.person.getPersonalEmail(),
                this.person.getCity(),
                this.person.getActive(),
                this.person.getCreatedDate(),
                this.person.getImagenUrl(),
                this.person.getTerminationDate()*/