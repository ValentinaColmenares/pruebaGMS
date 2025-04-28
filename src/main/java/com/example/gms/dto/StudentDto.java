package com.example.gms.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

  private Long id;
  private String name;
  private String lastName;
  private String email;
  private LocalDate birthDate;

}