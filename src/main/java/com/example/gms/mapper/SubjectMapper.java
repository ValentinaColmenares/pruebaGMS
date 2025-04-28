package com.example.gms.mapper;

import com.example.gms.dto.SubjectDto;
import com.example.gms.entity.Subject;

public class SubjectMapper {

  public static SubjectDto mapToSubjectDto(Subject subject){
    return new SubjectDto(
      subject.getId(),
      subject.getName(),
      subject.getCode(),
      subject.getCredits()
    );
  }

  public static Subject mapToSubject(SubjectDto subjectDto){
    return new Subject(
      subjectDto.getId(),
      subjectDto.getName(),
      subjectDto.getCode(),
      subjectDto.getCredits()
    );
  }

}
