package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Books;
import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import com.example.demo.service.BookService;
import com.example.demo.service.StudentService;
import com.example.demo.service.SubjectService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private BookService bookingService;
	
	@PostMapping("/student/add")
	Student add(@RequestBody Student student) {
		return studentService.addStudent(student);
		
	}
	
	@PutMapping("/student/update/{sId}")
	String update(@PathVariable int sId,@RequestBody Student student) throws Exception{
		return studentService.updateStudent(sId, student);
	}
	
	@DeleteMapping("/student/delete/{sId}")
	String delete(@PathVariable int sId)throws Exception{
		return studentService.deleteStudent(sId);
	}
	
	@GetMapping("/student/get/{sId}")
	Student get(@PathVariable int sId)throws Exception{
		return studentService.getByStudentId(sId);
	}
	
	@GetMapping("/student/get/{subId}")
	Student getbyStudent(@PathVariable int subId)throws Exception{
		return studentService.getByStudentId(subId);
	}
	
	
	  @GetMapping("/student/getAllStudent") 
	  List<Student> getAll(){ return
	  studentService.getAllStudent(); }
	 
	
	@GetMapping("/student/assignSubjectToStudent/{stuId}/{subId}")
	public Student assignSubjectToStudent(@PathVariable int stuId,@PathVariable int subId) throws Exception {
		Student student=studentService.getByStudentId(stuId);
		System.out.println(student);
		//Optional<Subject> subject=subjectRepository.findById(subId);
		Subject subject=subjectService.getBySubjectId(subId);
		student.setSubject(subject);
		System.out.println(student);
		studentService.addStudent(student);		
		return student;
		
	}
	
	
	
	
	
	

}
