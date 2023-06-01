package com.example.block7crudvalidation_v2.domain;

import com.example.block7crudvalidation_v2.dto.input.StudentInputDto;
import com.example.block7crudvalidation_v2.dto.output.StudentOutputDtoFull;
import com.example.block7crudvalidation_v2.dto.output.StudentOutputDtoSimple;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


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
    @ManyToMany
    @JsonManagedReference
    private Set<Subject> subjects;
    @ManyToOne
    @JsonBackReference
    private Teacher teacher;
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
                this.branch,
                this.subjects
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
                this.branch,
                this.subjects,
                this.teacher
        );
    }
}