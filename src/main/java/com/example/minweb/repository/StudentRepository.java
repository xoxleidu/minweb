package com.example.minweb.repository;

import com.example.minweb.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentRepository extends JpaRepository<Student,Integer>,JpaSpecificationExecutor<Student> {
}
