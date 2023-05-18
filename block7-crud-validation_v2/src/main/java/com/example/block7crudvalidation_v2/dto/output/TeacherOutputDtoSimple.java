package com.example.block7crudvalidation_v2.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherOutputDtoSimple {
    private int idTeacher;
    private int idPerson;
    private String comments;
    private String branch;
}
