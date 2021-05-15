package com.example.studentservice.mapper;

import com.example.studentservice.dto.StudentDTO;
import com.example.studentservice.model.Student;
import org.modelmapper.ModelMapper;

public class StudentMapper {
    private static ModelMapper modelMapper=new ModelMapper();
    public static StudentDTO convertToDto(Student student){
        return modelMapper.map(student,StudentDTO.class);
    }
    public static Student convertToEntity(StudentDTO studentDTO){
        return modelMapper.map(studentDTO,Student.class);
    }
}
