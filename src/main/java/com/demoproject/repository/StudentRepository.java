package com.demoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoproject.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
