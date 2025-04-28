package com.example.gms.service;

import java.util.List;

import com.example.gms.dto.StudentDto;

public interface StudentService {
  StudentDto createStudent(StudentDto studentDto);

  StudentDto getStudentById(Long studentId);

  List<StudentDto> getAllStudents();
}
