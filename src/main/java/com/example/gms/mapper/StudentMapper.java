package com.example.gms.mapper;

import com.example.gms.dto.StudentDto;
import com.example.gms.entity.Student;

public class StudentMapper {

  public static StudentDto mapToStudentDto(Student student){
    return new StudentDto(
      student.getId(),
      student.getName(),
      student.getLastName(),
      student.getEmail(),
      student.getBirthDate()
    );
  }

  public static Student mapToStudent(StudentDto studentDto){
    return new Student(
      studentDto.getId(),
      studentDto.getName(),
      studentDto.getLastName(),
      studentDto.getEmail(),
      studentDto.getBirthDate()
    );
  }
}