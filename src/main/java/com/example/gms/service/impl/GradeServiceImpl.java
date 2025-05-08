package com.example.gms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.gms.dto.GradeDto;
import com.example.gms.entity.Grade;
import com.example.gms.entity.Student;
import com.example.gms.entity.Subject;
import com.example.gms.exception.ResourceNotFoundException;
import com.example.gms.mapper.GradeMapper;
import com.example.gms.repository.GradeRepository;
import com.example.gms.repository.StudentRepository;
import com.example.gms.repository.SubjectRepository;
import com.example.gms.service.GradeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GradeServiceImpl implements GradeService{
  
  private GradeRepository gradeRepository;
  private StudentRepository studentRepository;
  private SubjectRepository subjectRepository;

  @Override
  public GradeDto createGrade(GradeDto gradeDto) {
    Grade grade = GradeMapper.mapToGrade(gradeDto);
    Grade savedGrade = gradeRepository.save(grade);
    return GradeMapper.mapToGradeDto(savedGrade);   
  }

  @Override
  public List<GradeDto> getGradesByStudentId(Long studentId) {
    List<Grade> grades = gradeRepository.findByIdStudent_Id(studentId);
    return grades.stream().map((grade) -> GradeMapper.mapToGradeDto(grade))
            .collect(Collectors.toList());
  }

  @Override
  public List<GradeDto> getAllGrades() {
    List<Grade> grades = gradeRepository.findAll();
    return grades.stream().map((grade) -> GradeMapper.mapToGradeDto(grade))
            .collect(Collectors.toList());
  }

  @Override
  public GradeDto updateGrade(Long gradeId, GradeDto updatedGrade) {
    Grade grade = gradeRepository.findById(gradeId).orElseThrow(
      () -> new ResourceNotFoundException("Grade is not exists with given id: " + gradeId)
    );

    Student student = studentRepository.findById(updatedGrade.getIdStudent()).orElseThrow(
      () -> new ResourceNotFoundException("Student is not exists with given id: " + updatedGrade.getIdStudent())
    );

    Subject subject = subjectRepository.findById(updatedGrade.getIdSubject()).orElseThrow(
      () -> new ResourceNotFoundException("Subject is not exists with given id: " + updatedGrade.getIdSubject())
    );

    grade.setValue(updatedGrade.getValue());
    grade.setRegistrationDate(updatedGrade.getRegistrationDate());
    grade.setIdStudent(student);
    grade.setIdSubject(subject);

    Grade updatedGradeObj = gradeRepository.save(grade);

    return GradeMapper.mapToGradeDto(updatedGradeObj);
  }

  @Override
  public void deleteGrade(Long gradeId) {
    gradeRepository.findById(gradeId).orElseThrow(
      () -> new ResourceNotFoundException("Grade is not exists with given id: " + gradeId)
    );
    
    gradeRepository.deleteById(gradeId);
  }

}
