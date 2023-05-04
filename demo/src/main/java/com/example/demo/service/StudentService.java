package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	
	Student add(Student student);
	
	String update(int sId, Student student) throws Exception;
	
	String delete(int sId)throws Exception;
	
	Student get(int sId)throws Exception;
	
	List<Student> getAll();

}
