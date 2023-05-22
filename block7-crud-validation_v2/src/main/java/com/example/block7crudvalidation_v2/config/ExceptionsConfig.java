package com.example.block7crudvalidation_v2.config;

import com.example.block7crudvalidation_v2.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionsConfig {
    Date timestamp;
    int HttpCode;
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomError> handlerEntityNotFoundException (Exception e) {
        CustomError error = new CustomError();
        error.setTimestamp(new Date());
        error.setHttpCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<CustomError> handlerUnprocessableEntityException (Exception e) {
        CustomError error = new CustomError();
        error.setTimestamp(new Date());
        error.setHttpCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(OutputTypeNotFoundException.class)
    public ResponseEntity<CustomError> handlerOutputTypeNotFoundException (Exception e) {
        CustomError error = new CustomError();
        error.setTimestamp(new Date());
        error.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SubjectHasStudentsException.class)
    public ResponseEntity<CustomError> handlerSubjectHasStudentsException (Exception e) {
        CustomError error = new CustomError();
        error.setTimestamp(new Date());
        error.setHttpCode(HttpStatus.FAILED_DEPENDENCY.value());
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.FAILED_DEPENDENCY);
    }
}