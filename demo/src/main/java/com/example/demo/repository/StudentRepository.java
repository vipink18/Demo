package com.example.demo.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Books;
import com.example.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

		
}
