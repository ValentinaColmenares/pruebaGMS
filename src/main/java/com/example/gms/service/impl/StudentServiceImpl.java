package com.example.gms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.gms.dto.StudentDto;
import com.example.gms.entity.Student;
import com.example.gms.exception.ResourceNotFoundException;
import com.example.gms.mapper.StudentMapper;
import com.example.gms.repository.StudentRepository;
import com.example.gms.service.StudentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

  private StudentRepository studentRepository;

  @Override
  public StudentDto createStudent(StudentDto studentDto) {
    Student student = StudentMapper.mapToStudent(studentDto);
    Student savedStudent = studentRepository.save(student);
    return StudentMapper.mapToStudentDto(savedStudent);
  }

  @Override
  public StudentDto getStudentById(Long studentId) {
    Student student = studentRepository.findById(studentId).orElseThrow(() -> 
                      new ResourceNotFoundException("Student is not exists with given id : " + studentId));
    return StudentMapper.mapToStudentDto(student);
  }

  @Override
  public List<StudentDto> getAllStudents() {
    List<Student> students = studentRepository.findAll();
    return students.stream().map((student) -> StudentMapper.mapToStudentDto(student))
                      .collect(Collectors.toList());
  }

  @Override
  public StudentDto updateStudent(Long studentId, StudentDto updatedStudent) {
    Student student = studentRepository.findById(studentId).orElseThrow(
      () -> new ResourceNotFoundException("Student is not exists with given id: " + studentId)
    );

    student.setName(updatedStudent.getName());
    student.setLastName(updatedStudent.getLastName());
    student.setEmail(updatedStudent.getEmail());
    student.setBirthDate(updatedStudent.getBirthDate());

    Student updatedStudentObj = studentRepository.save(student);

    return StudentMapper.mapToStudentDto(updatedStudentObj);
  }

  @Override
  public void deleteStudent(Long studentId) {
    Student student = studentRepository.findById(studentId).orElseThrow(
      () -> new ResourceNotFoundException("Student is not exists with given id: " + studentId)
    );
    
    studentRepository.deleteById(studentId);
  }

}