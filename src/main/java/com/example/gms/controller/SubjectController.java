package com.example.gms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gms.dto.StudentDto;
import com.example.gms.dto.SubjectDto;
import com.example.gms.service.SubjectService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/api/materias")
public class SubjectController {

  private SubjectService subjectService;

  // Build Add Subject REST API
  @PostMapping
  public ResponseEntity<SubjectDto> createSubject(@RequestBody SubjectDto subjectDto) {
      SubjectDto savedSubject = subjectService.createSubject(subjectDto);
      return new ResponseEntity<>(savedSubject, HttpStatus.CREATED);
  }
  
  // Build Get Subject REST API
  @GetMapping("{id}")
  public ResponseEntity<SubjectDto> getSubjectById(@PathVariable("id") Integer subjectId) {
    SubjectDto subjectDto = subjectService.getSubjectById(subjectId);
    return ResponseEntity.ok(subjectDto);
  }

  // Build Get All Subjects REST API
  @GetMapping
  public ResponseEntity<List<SubjectDto>> getAllSubjects() {
      List<SubjectDto> subjects = subjectService.getAllSubjects();
      return ResponseEntity.ok(subjects);
  }
  
  // Build Update Subject REST API
  @PutMapping("{id}")
  public ResponseEntity<SubjectDto> updateSubject(@PathVariable("id") Integer subjectId, 
                                                  @RequestBody SubjectDto updatedSubject) {
      SubjectDto subjectDto = subjectService.updateSubject(subjectId, updatedSubject);
      return ResponseEntity.ok(subjectDto);
  }

  // Build Delete Subject REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable("id") Integer subjectId){
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.ok("Subject deleted successfully!");
    }
}
