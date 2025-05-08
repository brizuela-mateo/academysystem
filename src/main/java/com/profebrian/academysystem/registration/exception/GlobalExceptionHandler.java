package com.profebrian.academysystem.registration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({StudentNotFoundException.class})
    public ResponseEntity<?> handleStudentNotFound(StudentNotFoundException ex){
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    // GlobalExceptionHandler.java

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleInvalidIdFormat() {
        return new ResponseEntity<>("Invalid Id format", HttpStatus.BAD_REQUEST);
    }

}
