package com.example.gms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.gms.dto.SubjectDto;
import com.example.gms.entity.Subject;
import com.example.gms.exception.ResourceNotFoundException;
import com.example.gms.mapper.SubjectMapper;
import com.example.gms.repository.SubjectRepository;
import com.example.gms.service.SubjectService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

  private SubjectRepository subjectRepository;

  @Override
  public SubjectDto createSubject(SubjectDto subjectDto) {
    Subject subject = SubjectMapper.mapToSubject(subjectDto);
    Subject savedStudent = subjectRepository.save(subject);
    return SubjectMapper.mapToSubjectDto(savedStudent);
  }

  @Override
  public SubjectDto getSubjectById(Integer subjectId) {
    Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> 
                      new ResourceNotFoundException("Subject is not exists with given id : " + subjectId));
    return SubjectMapper.mapToSubjectDto(subject);
  }

  @Override
  public List<SubjectDto> getAllSubjects() {
    List<Subject> subjects = subjectRepository.findAll();
    return subjects.stream().map((subject) -> SubjectMapper.mapToSubjectDto(subject))
                      .collect(Collectors.toList());
  }

  @Override
  public SubjectDto updateSubject(Integer subjectId, SubjectDto updatedSubject){
    Subject subject = subjectRepository.findById(subjectId).orElseThrow(
                      () -> new ResourceNotFoundException("Subject in not exists with given id: " + subjectId)
    );

    subject.setName(updatedSubject.getName());
    subject.setCode(updatedSubject.getCode());
    subject.setCredits(updatedSubject.getCredits());

    Subject updatedSubjectObj = subjectRepository.save(subject);

    return SubjectMapper.mapToSubjectDto(updatedSubjectObj);

  }

  @Override
  public void deleteSubject(Integer subjectId) {
    Subject subject = subjectRepository.findById(subjectId).orElseThrow(
      () -> new ResourceNotFoundException("Subject is not exists with given id: " + subjectId)
    );
    
    subjectRepository.deleteById(subjectId);
  }

}
