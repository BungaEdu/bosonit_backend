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
        Person person = new Person();
        person.setIdPerson(studentInputDto.getIdPerson());
        this.person = person;
        this.hourPerWeek = studentInputDto.getHourPerWeek();
        this.comments = studentInputDto.getComments();
        this.branch = studentInputDto.getBranch();
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