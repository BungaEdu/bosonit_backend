package com.example.block7crudvalidation_v2.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class CustomError {
    Date timestamp;
    int HttpCode;
    String mensaje;
}
