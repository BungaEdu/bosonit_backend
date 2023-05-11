package com.example.block7crudvalidation_v2.domain;

import com.example.block7crudvalidation_v2.controller.dto.StudentInputDto;
import com.example.block7crudvalidation_v2.controller.dto.StudentOutputDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue()
    private Integer idStudent;
    @OneToOne
    @JoinColumn(name = "id_person")
    private Person person;
    private Integer hourPerWeek;
    private String comments;
    private String branch;

    public Student(StudentInputDto studentInputDto) {
        this.idStudent = studentInputDto.getId_student();
        this.hourPerWeek = studentInputDto.getHourPerWeek();
        this.comments = studentInputDto.getComments();
        this.branch = studentInputDto.getBranch();
    }
//Tienes que poner full y simple, no hay otra manera.
    public StudentOutputDto studentToStudentOutputDto() {
        return new StudentOutputDto(
                this.idStudent,
                this.hourPerWeek,
                this.comments,
                this.branch,
                this.person.getIdPerson(),
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
                this.person.getTerminationDate()
        );
    }

/*    public StudentOutputDtoFull studentToStudentOutputDto() {
        return new StudentOutputDto(
                this.idStudent,
                this.hourPerWeek,
                this.comments,
                this.branch
        );
    }*/
}
