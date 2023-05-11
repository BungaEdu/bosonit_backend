package com.example.block7crudvalidation_v2.domain;

import com.example.block7crudvalidation_v2.controller.dto.StudentInputDto;
import com.example.block7crudvalidation_v2.controller.dto.StudentOutputDto;
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
    @GeneratedValue()
    private Integer idStudent;
    @OneToOne
    @JoinColumn(name = "id_person")
    private Integer id_person;
    private Integer hourPerWeek;
    private String comments;
    private String branch;

    public Student(StudentInputDto studentInputDto) {
        this.idStudent = studentInputDto.getId_student();
        this.hourPerWeek = studentInputDto.getHourPerWeek();
        this.comments = studentInputDto.getComments();
        this.branch = studentInputDto.getBranch();
    }

    public StudentOutputDto studentToStudentOutputDto() {
        return new StudentOutputDto(
                this.idStudent,
                this.hourPerWeek,
                this.comments,
                this.branch
        );
    }
}
