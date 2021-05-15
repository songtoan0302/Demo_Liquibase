package com.example.studentservice.repository;

import com.example.studentservice.dto.StudentDTO;
import com.example.studentservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    StudentDTO deleteStudentById(int id);

    StudentDTO getUserById(int id);
}
