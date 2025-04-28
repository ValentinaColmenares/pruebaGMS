package com.example.gms.entity;

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
  private Integer id;

  @DecimalMin(value = "0.0")
  @DecimalMax(value = "5.0")
  @Column(name = "valor", precision = 3, scale = 1)
  private Double value;

  @Column(name = "fecha_registro")
  private LocalDate registrationDate;

  @ManyToOne(optional = false)
  @JoinColumn(name = "id_alumno", referencedColumnName = "id")
  private Long idStudent;

  @ManyToOne(optional = false)
  @JoinColumn(name = "id_materia", referencedColumnName = "id")
  private Integer idSubject;

}
