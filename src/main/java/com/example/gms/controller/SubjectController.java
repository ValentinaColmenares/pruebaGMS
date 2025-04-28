package com.example.gms.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gms.dto.SubjectDto;
import com.example.gms.service.SubjectService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/materias")
public class SubjectController {

  private SubjectService subjectService;
  
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
}
