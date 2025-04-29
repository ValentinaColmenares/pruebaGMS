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
@Table(name="alumno")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre")
  private String name;

  @Column(name = "apellido")
  private String lastName;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "fecha_nacimiento")
  private LocalDate birthDate;

  @OneToMany(mappedBy = "idStudent", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Grade> grades;

  public Student(Long id, String name, String lastName, String email, LocalDate birthDate) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.email = email;
    this.birthDate = birthDate;
  }

}