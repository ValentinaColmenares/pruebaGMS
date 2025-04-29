package com.example.gms.mapper;

import com.example.gms.dto.GradeDto;
import com.example.gms.entity.Grade;
import com.example.gms.entity.Student;
import com.example.gms.entity.Subject;

public class GradeMapper {
  
  public static GradeDto mapToGradeDto(Grade grade){
    return new GradeDto(
      grade.getId(),
      grade.getValue(),
      grade.getRegistrationDate(),
      grade.getIdStudent().getId(),
      grade.getIdSubject().getId()
    );
  }

  public static Grade mapToGrade(GradeDto gradeDto){
    Student student = new Student();
    student.setId(gradeDto.getIdStudent());

    Subject subject = new Subject();
    subject.setId(gradeDto.getIdSubject());
    
    return new Grade(
      gradeDto.getId(),
      gradeDto.getValue(),
      gradeDto.getRegistrationDate(),
      student,
      subject
    );
  }

}
