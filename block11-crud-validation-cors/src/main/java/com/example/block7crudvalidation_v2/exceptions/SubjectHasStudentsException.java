package com.example.block7crudvalidation_v2.exceptions;

public class SubjectHasStudentsException extends RuntimeException {
    public SubjectHasStudentsException() {
        super();
    }

    public SubjectHasStudentsException(String message) {
        super(message);
    }
}