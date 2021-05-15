package com.example.studentservice.controller;

import com.example.studentservice.dto.StudentDTO;

import com.example.studentservice.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



@RestController
@Slf4j
@RequestMapping(value = "/api/v1/students")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping()
    public ResponseEntity<Object> getStudentById(int id){


    return new ResponseEntity<Object> (studentService.getStudentByID(id),HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Object> addStudent(StudentDTO studentDTO){
    StudentDTO studentAdded = studentService.addStudent(studentDTO);
    return new ResponseEntity<Object>(studentAdded, HttpStatus.CREATED);


    }
    @PutMapping()
    public ResponseEntity<Object> updateStudent(StudentDTO studentDTO){
    StudentDTO studentUpdated =studentService.updateStudent(studentDTO);
    if(studentUpdated==null){
        return new ResponseEntity<Object>("Student update failed",HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<Object>(studentUpdated,HttpStatus.ACCEPTED);
    }
    @DeleteMapping()
    public ResponseEntity<Object> deleteStudentById(@PathVariable("id") int id){

    return new ResponseEntity<Object>(studentService.deleteUserById(id),HttpStatus.OK);
    }

}
