package com.example.gms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gms.dto.GradeDto;
import com.example.gms.service.GradeService;

import lombok.AllArgsConstructor;

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

}
