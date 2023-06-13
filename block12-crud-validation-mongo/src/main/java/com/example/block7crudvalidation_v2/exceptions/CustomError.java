package com.example.block7crudvalidation_v2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomError {
    Date timestamp;
    int HttpCode;
    String message;
}
