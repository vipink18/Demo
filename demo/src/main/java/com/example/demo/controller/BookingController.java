package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Books;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.BookingService;


@RequestMapping("/book")
@RestController
public class BookingController {
	@Autowired
	private BookingService service;
//	
//	@Autowired
//	private StudentRepository studentRepository;
	
	@PostMapping("/add")
	Books add(@RequestBody Books books) {
		return service.add(books);
		
	}
	
	@PutMapping("/update/{bookId}")
	Books update(@PathVariable int bookId,@RequestBody Books book) throws Exception{
		return service.update(bookId, book);
	}
	
	@DeleteMapping("/delete/{bookId}")
	List<Books> delete(@PathVariable int bookId)throws Exception{
		return service.delete(bookId);
	}
	
	@GetMapping("/get/{bookId}")
	Books get(@PathVariable int bookId)throws Exception{
		return service.getById(bookId);
	}
	
//	@GetMapping("/student/get/{sId}")
//	Student getbyStudent(@PathVariable int subId)throws Exception{
//		return service.getById(sId);
//	}
	
	@GetMapping("/student/getAll")
	List<Books> getAll(){
		return service.getAll();
	}
	
	

}
