package com.example.block7crudvalidation_v2.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException() {
        super ();
    }

    public EntityNotFoundException (String message) {
        super(message);
    }
}
