package com.profebrian.academysystem.registration.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message, Integer id) {
        super(message);
    }
}
