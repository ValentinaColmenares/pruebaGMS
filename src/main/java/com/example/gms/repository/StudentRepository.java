package com.example.gms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
  
}
