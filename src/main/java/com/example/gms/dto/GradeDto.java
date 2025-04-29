package com.example.gms.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.gms.entity.Student;
import com.example.gms.entity.Subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GradeDto {
  
  private Long id;
  private BigDecimal value;
  private LocalDate registrationDate;
  private Student idStudent;
  private Subject idSubject;

}
