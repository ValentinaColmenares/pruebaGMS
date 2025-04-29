package com.example.gms.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

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
  private Long idStudent;
  private Integer idSubject;

}
