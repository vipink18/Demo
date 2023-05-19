package com.example.demo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;

import com.example.demo.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	

//	@Autowired
//	private Student st;
	
	@Override
	public Student addStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public String updateStudent(int sId, Student student)throws Exception {
		Student s=studentRepository.findById(sId).orElseThrow( () -> new Exception("Id not found"));
		
		
		
		s.setsMobileNo(student.getsMobileNo());		
		studentRepository.save(s);
		return "Updated successfully ";
	}

	@Override
	public String deleteStudent(int sId) throws Exception{
		Student s  = studentRepository.findById(sId).orElseThrow( () -> new Exception("Id not found"));
		studentRepository.delete(s);
		return "Student deleted ";
	}

	@Override
	public Student getByStudentId(int sId) throws Exception{
		 
		return studentRepository.findById(sId).orElseThrow( () -> new Exception("Id not found"));
	}
	
	 @Override public List<Student> getAllStudent() {
	  
	 return studentRepository.findAll(); }
	/*  
	 * @Override public Student getStudentBySubId(int subId) {
	 * 
	 * Student stud = repo.findById(subId).get(); return stud; }
	 * 
	 * @Override public Student getsId(int bookId) { Student student =
	 * repo.getById(bookRepository.findById(bookId));
	 * 
	 * return student; }
	 * 
	 * @Override public void saveAll(List<Student> result) { repo.saveAll(result);
	 * 
	 * }
	 */
}
