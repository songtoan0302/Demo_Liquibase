package com.example.studentservice.service.implement;

import com.example.studentservice.dto.StudentDTO;
import com.example.studentservice.exception.StudentNotFoundException;
import com.example.studentservice.mapper.StudentMapper;
import com.example.studentservice.model.Student;
import com.example.studentservice.repository.StudentRepository;
import com.example.studentservice.service.StudentService;
import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplement implements StudentService {
    private  final  StudentRepository studentRepository ;
    @Autowired
    public StudentServiceImplement(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO getStudentByID(int id) {
        return studentRepository.getUserById(id);
    }

    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student= StudentMapper.convertToEntity(studentDTO);

        return StudentMapper.convertToDto(studentRepository.save(student));
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        Student updateStudent = studentRepository.findById(studentDTO.getId())
                .map(student -> StudentMapper.convertToEntity(studentDTO))
                .map(studentRepository::saveAndFlush).orElseThrow(StudentNotFoundException::new);
        return StudentMapper.convertToDto(updateStudent);
    }

    @Override
    public StudentDTO deleteUserById(int id) {
        return studentRepository.deleteStudentById(id);
    }

    @Override
    public List<StudentDTO> getAllStudent() {
        List<Student> students= studentRepository.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for(Student student:students){
            studentDTOS.add(StudentMapper.convertToDto(student));
        }

        return studentDTOS;
    }
    @Override
    public StudentDTO findStudentById(int id){
        Student students=studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
        return StudentMapper.convertToDto(students);

    }
}
