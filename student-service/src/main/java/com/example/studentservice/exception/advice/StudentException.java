package com.example.studentservice.exception.advice;

import com.example.studentservice.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentException {
    @ExceptionHandler
     public ResponseEntity<Object> exception (StudentNotFoundException exception){
        return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
    }
}
