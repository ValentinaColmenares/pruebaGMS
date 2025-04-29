package com.example.gms.service.impl;

import org.springframework.stereotype.Service;

import com.example.gms.dto.GradeDto;
import com.example.gms.entity.Grade;
import com.example.gms.mapper.GradeMapper;
import com.example.gms.repository.GradeRepository;
import com.example.gms.service.GradeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GradeServiceImpl implements GradeService{
  
  private GradeRepository gradeRepository;

  @Override
  public GradeDto createGrade(GradeDto gradeDto) {
    Grade grade = GradeMapper.mapToGrade(gradeDto);
    Grade savedGrade = gradeRepository.save(grade);
    return GradeMapper.mapToGradeDto(savedGrade);   
  }

}
