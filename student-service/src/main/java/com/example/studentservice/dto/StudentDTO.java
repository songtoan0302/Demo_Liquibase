package com.example.studentservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO implements Serializable {
    @JsonProperty("student_id")
        private int id;
    @JsonProperty("student_name")
        private String name;
    @JsonProperty("student_address")
        private String address;
    @JsonProperty("student_email")
        private String email;

}
