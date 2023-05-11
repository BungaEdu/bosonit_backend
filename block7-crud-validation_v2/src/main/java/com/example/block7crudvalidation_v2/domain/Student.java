package com.example.block7crudvalidation_v2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id_student;
    @OneToOne
    @JoinColumn(name = "id_person")
    Person person;
    @Column(name = "hourPerWeek")
    Integer hourPerWeek;
    @Column(name = "coments")
    String coments;
    @Column(name = "branch")
    String branch;
}

