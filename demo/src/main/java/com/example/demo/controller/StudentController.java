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

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/student/add")
	Student add(@RequestBody Student student) {
		return service.add(student);
	}
	
	@PutMapping("/student/update/{sId}")
	String update(@PathVariable int sId,@RequestBody Student student) throws Exception{
		return service.update(sId, student);
	}
	
	@DeleteMapping("/student/delete{sId}")
	String delete(@PathVariable int sId)throws Exception{
		return service.delete(sId);
	}
	
	@GetMapping("/student/get{sId}")
	Student get(@PathVariable int sId)throws Exception{
		return service.get(sId);
	}
	
	@GetMapping("/student/getAll")
	List<Student> getAll(){
		return service.getAll();
	}

}
