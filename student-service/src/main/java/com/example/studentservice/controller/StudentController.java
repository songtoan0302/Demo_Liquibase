package com.example.studentservice.controller;

import com.example.studentservice.dto.StudentDTO;


import com.example.studentservice.service.StudentService;

import com.sun.istack.Nullable;
import liquibase.pro.packaged.T;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@Slf4j
@RequestMapping(value = "/api/v1/students")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") int id){
        if(Objects.nonNull(studentService.findStudentById(id))) {
            return new ResponseEntity<>(studentService.getStudentByID(id), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(studentService.getAllStudent(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Object> addStudent(@RequestBody StudentDTO studentDTO){
    StudentDTO studentAdded = studentService.addStudent(studentDTO);
    return new ResponseEntity<>(studentAdded, HttpStatus.CREATED);


    }
    @PutMapping
    public ResponseEntity<?> updateStudent(StudentDTO studentDTO) {
        if(studentService.findStudentById(studentDTO.getId())!=null){
            StudentDTO studentUpdated = studentService.updateStudent(studentDTO);

            return new ResponseEntity<>(studentUpdated, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Student update failed", HttpStatus.NOT_FOUND);

        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id){
    if(null!=studentService.findStudentById(id)){
        return new ResponseEntity<>(studentService.deleteUserById(id),HttpStatus.OK);
    }
    else {
        return new ResponseEntity<>("Student does not exist!",HttpStatus.NOT_FOUND);
    }
    }

}
