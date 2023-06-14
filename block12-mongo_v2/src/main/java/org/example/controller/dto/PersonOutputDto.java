package org.example.controller.dto;

import lombok.*;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonOutputDto {
    private String idPersona;
    private String name;
    private String surname;
    private boolean active;
    private LocalDate createdDate;
}
