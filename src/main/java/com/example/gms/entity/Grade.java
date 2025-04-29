package com.example.gms.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="nota")
public class Grade {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @DecimalMin(value = "0.0")
  @DecimalMax(value = "5.0")
  @Column(name = "valor", precision = 3, scale = 1)
  private BigDecimal value;

  @Column(name = "fecha_registro")
  private LocalDate registrationDate;

  @ManyToOne(optional = false)
  @JoinColumn(name = "id_alumno", referencedColumnName = "id")
  private Student idStudent;

  @ManyToOne(optional = false)
  @JoinColumn(name = "id_materia", referencedColumnName = "id")
  private Subject idSubject;
  
}
