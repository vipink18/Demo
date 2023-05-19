package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	
	Student addStudent(Student student);
	
	String updateStudent(int sId, Student student) throws Exception;
	
	String deleteStudent(int sId)throws Exception;
	
	Student getByStudentId(int sId)throws Exception ;

	List<Student> getAllStudent();
	
	
	/*
	 * List<Student> getAll();
	 * 
	 * Student getStudentBySubId(int subId);
	 * 
	 * Student getsId(int bookId);
	 * 
	 * public void saveAll(List<Student> result);
	 */

}
