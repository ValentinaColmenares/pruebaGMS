package com.example.gms.service;

import java.util.List;

import com.example.gms.dto.SubjectDto;

public interface SubjectService {
  SubjectDto getSubjectById(Integer subjectId);

  List<SubjectDto> getAllSubjects();
}
