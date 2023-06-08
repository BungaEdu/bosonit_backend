package com.example.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.controller.dto.FicheroInput;
import com.example.controller.dto.FicheroOutput;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "fichero")
public class Fichero {
    @Id
    @GeneratedValue
    @Column(name = "id_fichero")
    private int idFichero;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date uploadDate;
    private String category;

    public Fichero(FicheroInput ficheroInput) {
        this.name = ficheroInput.getName();
        this.uploadDate = ficheroInput.getUploadDate();
        this.category = ficheroInput.getCategory();
    }

    public FicheroOutput ficheroToFicheroOutput () {
        return new FicheroOutput (
                this.idFichero = idFichero,
                this.name = name,
                this.uploadDate = uploadDate,
                this.category = category
        );
    }
}