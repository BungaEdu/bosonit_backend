package com.example.block7crudvalidation.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@Data
@AllArgsConstructor
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends RuntimeException {
    private Date timeStamp = new Date();
    public UnprocessableEntityException(){
    }
    public CustomError getError() {
        return new CustomError(timeStamp, HttpStatus.UNPROCESSABLE_ENTITY.value(), "Error UnprocessableEntityException: campos incorrectos");
    }
}
