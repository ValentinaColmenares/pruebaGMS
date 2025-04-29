package com.example.gms.service;

import java.util.List;

import com.example.gms.dto.SubjectDto;

public interface SubjectService {
  SubjectDto createSubject(SubjectDto subjectDto);

  SubjectDto getSubjectById(Integer subjectId);

  List<SubjectDto> getAllSubjects();

  SubjectDto updateSubject(Integer subjectId, SubjectDto updatedSubject);

  void deleteSubject(Integer subjectId);
}
