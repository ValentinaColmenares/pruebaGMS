package com.example.gms.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "materia")
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nombre")
  private String name;

  @Column(name = "codigo", unique = true)
  private String code;

  @Column(name = "creditos")
  private Integer credits;

  @OneToMany(mappedBy = "idSubject", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Grade> grades;

  public Subject(Integer id, String name, String code, Integer credits) {
    this.id = id;
    this.name = name;
    this.code = code;
    this.credits = credits;
  }
}