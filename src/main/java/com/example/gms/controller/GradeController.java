package com.example.gms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gms.dto.GradeDto;
import com.example.gms.service.GradeService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@AllArgsConstructor
@RestController
@RequestMapping("api/notas")
public class GradeController {

  private GradeService gradeService;

  // Build Add Grade REST API
  @PostMapping
  public ResponseEntity<GradeDto> createGrade(@RequestBody GradeDto gradeDto) {
      GradeDto savedGrade = gradeService.createGrade(gradeDto);
      return new ResponseEntity<>(savedGrade, HttpStatus.CREATED);
  }

  // Build Get Grades By Student Id REST API
  @GetMapping("alumno/{id}")
  public ResponseEntity<List<GradeDto>> getGradesByStudentId(@PathVariable("id") Long idStudent){
    List<GradeDto> grades = gradeService.getGradesByStudentId(idStudent);
    return ResponseEntity.ok(grades);
  }
  
}
