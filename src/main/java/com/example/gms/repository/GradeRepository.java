package com.example.gms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gms.entity.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long>{
  List<Grade> findByIdStudent_Id(Long studentId);
}
