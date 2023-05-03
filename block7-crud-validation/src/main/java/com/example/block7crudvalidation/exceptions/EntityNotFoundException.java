package com.example.block7crudvalidation.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    private Date timeStamp = new Date();

    public CustomError getError() {
        return new CustomError(timeStamp, HttpStatus.NOT_FOUND.value(), "Error EntityNotFoundException: no existe ese ID");
    }

}
