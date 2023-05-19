package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Books;
import com.example.demo.entity.Student;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {

	
	
	
	

}
