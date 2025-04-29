package com.example.gms.service;

import java.util.List;

import com.example.gms.dto.GradeDto;

public interface GradeService {
  GradeDto createGrade(GradeDto gradeDto);

  List<GradeDto> getGradesByStudentId(Long studentId);

  List<GradeDto> getAllGrades();

  GradeDto updateGrade(Long gradeId, GradeDto updatedGrade);

  void deleteGrade(Long gradeId);
}
