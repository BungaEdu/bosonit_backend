package com.example.block7crudvalidation.domain;


import com.example.block7crudvalidation.controller.dto.StudentInputDto;
import com.example.block7crudvalidation.controller.dto.StudentOutputDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue
    private int id_student;
    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
    @Column(name = "horas_por_semana")
    private Integer num_hours_week;
    @Column(name = "comentarios")
    private String coments;
    @Column(name = "rama")
    private String branch;

    public Student(StudentInputDto studentInputDto) {
        //Hacer find por persona ID

        persona = new Persona();
        this.persona.setId_persona(studentInputDto.getPersona_id());
        this.num_hours_week = studentInputDto.getNum_hours_week();
        this.coments = studentInputDto.getComents();
        this.branch = studentInputDto.getBranch();
    }

    public StudentOutputDto studentToStudentOutputDto() {
        return new StudentOutputDto(
                this.id_student,
                this.persona,
                this.num_hours_week,
                this.coments,
                this.branch
        );
    }

/*    public StudentOutputDtoFull studentToStudentOutputDtoFull() {
        return new StudentOutputDtoFull(
                this.id_student,
                this.persona.getId(),
                this.persona.getUsuario(),
                this.persona.getPassword(),
                this.persona.getName(),
                this.persona.getSurname(),
                this.persona.getCompanyEmail(),
                this.persona.getPersonalEmail(),
                this.persona.getCity(),
                this.persona.getActive(),
                this.persona.getCreatedDate(),
                this.persona.getImagenUrl(),
                this.persona.getTerminationDate(),
                this.num_hours_week,
                this.coments,
                this.branch
        );
    }

}

    public StudentOutputDtoSimple studentToStudentOutputDtoSimple(StudentInputDto studentInputDto) {
        return new StudentOutputDtoSimple(
                this.id_student,
                this.num_hours_week,
                this.coments,
                this.branch
        );
    }*/
}

