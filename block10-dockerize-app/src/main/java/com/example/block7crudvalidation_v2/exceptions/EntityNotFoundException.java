package com.example.block7crudvalidation_v2.exceptions;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException() {
        super ();
    }

    public EntityNotFoundException (String message) {
        super(message);
    }
}
