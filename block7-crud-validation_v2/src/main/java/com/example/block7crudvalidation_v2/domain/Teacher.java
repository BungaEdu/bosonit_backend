package com.example.block7crudvalidation_v2.domain;

import com.example.block7crudvalidation_v2.dto.output.StudentOutputDtoSimple;
import com.example.block7crudvalidation_v2.dto.input.TeacherInputDto;
import com.example.block7crudvalidation_v2.dto.output.TeacherOutputDtoFull;
import com.example.block7crudvalidation_v2.dto.output.TeacherOutputDtoSimple;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue
    @Column(name = "id_teacher")
    private int idTeacher;
    @OneToOne
    @JoinColumn(name = "id_person")
    private Person person;
    @OneToMany (mappedBy = "teacher")
    private List<Student> students;
    private String comments;
    private String branch;


    public Teacher(TeacherInputDto teacherInputDto) {
        this.idTeacher = teacherInputDto.getIdTeacher();
        Person person = new Person();
        person.setIdPerson(teacherInputDto.getIdPerson());
        this.person = person;
        this.comments = teacherInputDto.getComments();
        this.branch = teacherInputDto.getBranch();
    }


    public TeacherOutputDtoSimple teacherToTeacherOutputDtoSimple() {
        return new TeacherOutputDtoSimple(
                this.idTeacher,
                this.person.getIdPerson(),
                this.comments,
                this.branch
        );
    }

    public TeacherOutputDtoFull teacherToTeacherOutputDtoFull() {
        return new TeacherOutputDtoFull(
                this.idTeacher,
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
                this.comments,
                this.branch,
                this.students
        );
    }
}