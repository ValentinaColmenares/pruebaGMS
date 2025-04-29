package com.example.gms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gms.dto.GradeDto;
import com.example.gms.service.GradeService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
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
  
  // Build Get All Grades REST API
  @GetMapping
  public ResponseEntity<List<GradeDto>> getAllGrades() {
      List<GradeDto> grades = gradeService.getAllGrades();
      return ResponseEntity.ok(grades);
  }

  // Build Update Grade REST API
  @PutMapping("{id}")
  public ResponseEntity<GradeDto> updateGrade(@PathVariable("id") Long gradeId, 
                                              @RequestBody GradeDto updatedGrade) {
      GradeDto gradeDto = gradeService.updateGrade(gradeId, updatedGrade);
      return ResponseEntity.ok(gradeDto);
  }

  // Build Delete Grade REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGrade(@PathVariable("id") Long gradeId){
        gradeService.deleteGrade(gradeId);
        return ResponseEntity.ok("Grade deleted successfully!");
  }

}