package com.example.studentservice.service;

import com.example.studentservice.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO getStudentByID(int id);

    StudentDTO addStudent(StudentDTO studentDTO);

    StudentDTO updateStudent(StudentDTO studentDTO);

    StudentDTO deleteUserById(int id);

    List<StudentDTO> getAllStudent();

}
