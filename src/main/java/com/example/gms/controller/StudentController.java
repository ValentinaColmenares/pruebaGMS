package com.example.gms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gms.dto.StudentDto;
import com.example.gms.service.StudentService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;





@AllArgsConstructor
@RestController
@RequestMapping("/api/alumnos")
public class StudentController {

  private StudentService studentService;

  // Build Add Student REST API
  @PostMapping
  public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
      StudentDto savedStudent = studentService.createStudent(studentDto);
      return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
  }
  
  // Build Get Student REST API
  @GetMapping("{id}")
  public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentId) {
    StudentDto studentDto = studentService.getStudentById(studentId);
    return ResponseEntity.ok(studentDto);
  }

  // Build Get All Students REST API
  @GetMapping
  public ResponseEntity<List<StudentDto>> getAllStudents() {
      List<StudentDto> students = studentService.getAllStudents();
      return ResponseEntity.ok(students);
  }
   
  // Build Update Student REST API
  @PutMapping("{id}")
  public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long studentId, 
                                                  @RequestBody StudentDto updatedStudent) {
      StudentDto studentDto = studentService.updateStudent(studentId, updatedStudent);
      return ResponseEntity.ok(studentDto);
  }

  // Build Delete Student REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student deleted successfully!");
    }

}