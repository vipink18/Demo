package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository repo;
	
//	@Autowired
//	private Student st;
	
	@Override
	public Student add(Student student) {
		
		return repo.save(student);
	}

	@Override
	public String update(int sId, Student student)throws Exception {
		Student s=repo.findById(sId).orElseThrow( () -> new Exception("Id not found"));
		
		
		
		s.setsMobileNo(student.getsMobileNo());		
		repo.save(s);
		return "Updated successfully ";
	}

	@Override
	public String delete(int sId) throws Exception{
		Student s  = repo.findById(sId).orElseThrow( () -> new Exception("Id not found"));
		repo.delete(s);
		return "Student deleted ";
	}

	@Override
	public Student getById(int sId) throws Exception{
		 
		return repo.findById(sId).orElseThrow( () -> new Exception("Id not found"));
	}

	@Override
	public List<Student> getAll() {
		
		return repo.findAll();
	}

	@Override
	public Student getStudentBySubId(int subId) {
		
		Student stud = repo.findById(subId).get();
		return stud;
	}

}
