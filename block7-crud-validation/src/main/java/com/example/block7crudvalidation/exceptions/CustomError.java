package com.example.block7crudvalidation.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomError extends Throwable {
    private Date timeStamp;
    private int httpCode;
    private String mensaje;

    public CustomError(LocalDateTime dateTime, int value, String s) {
    }
}