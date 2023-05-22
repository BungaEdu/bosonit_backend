package com.example.block7crudvalidation_v2.domain;

import com.example.block7crudvalidation_v2.dto.input.SubjectInputDto;
import com.example.block7crudvalidation_v2.dto.output.SubjectOutputDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int idSubject;
    @ManyToMany (mappedBy = "subjects")
    @JsonIgnore
    List<Student> students;
    String name;
    String comment;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    Date initialDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    Date finishDate;

    public Subject(SubjectInputDto subjectInputDto) {
        this.idSubject = subjectInputDto.getIdSubject();
        this.name = subjectInputDto.getName();
        this.comment = subjectInputDto.getComment();
        this.initialDate = subjectInputDto.getInitialDate();
        this.finishDate = subjectInputDto.getFinishDate();
    }


    public SubjectOutputDto subjectToSubjectOutputDto() {
        return new SubjectOutputDto(
                this.idSubject,
                this.name,
                this.comment,
                this.initialDate,
                this.finishDate
        );
    }
}