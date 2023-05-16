package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.SubjectRepository;
import com.example.demo.service.BookingService;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/student/add")
	Student add(@RequestBody Student student) {
		return service.add(student);
		
	}
	
	@PutMapping("/student/update/{sId}")
	String update(@PathVariable int sId,@RequestBody Student student) throws Exception{
		return service.update(sId, student);
	}
	
	@DeleteMapping("/student/delete/{sId}")
	String delete(@PathVariable int sId)throws Exception{
		return service.delete(sId);
	}
	
	@GetMapping("/student/get/{sId}")
	Student get(@PathVariable int sId)throws Exception{
		return service.getById(sId);
	}
	
	@GetMapping("/student/get/{subId}")
	Student getbyStudent(@PathVariable int subId)throws Exception{
		return service.getById(subId);
	}
	
	@GetMapping("/student/getAll")
	List<Student> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/student/assignSubjectToStudent/{stuId}/{subId}")
	public Student assignSubjectToStudent(@PathVariable int stuId,@PathVariable int subId) throws Exception {
		Student student=service.getById(stuId);
		System.out.println(student);
		Optional<Subject> subject=subjectRepository.findById(subId);
		student.setSubject(subject.get());
		System.out.println(student);
		service.add(student);		
		return student;
		
	}
	
	@PostMapping("/book/assignBookToStudent/{stuId}/{bookId}")
	public Student assignBookToStudent(@PathVariable int stuId,@PathVariable int bookId) throws Exception {
		Student student=service.getById(stuId);
		System.out.println(student);
		Books books=bookingService.getById(bookId);
		System.out.println(books);
		student.getBooks().add(books);
		return service.add(student);
		
	}
	
	

}
