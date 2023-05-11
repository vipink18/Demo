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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import com.example.demo.service.StudentService;
import com.example.demo.service.SubjectService;

@RequestMapping("/subject")
@RestController
public class SubjectController {

	@Autowired
	private SubjectService service;
	
	@Autowired
	private StudentService studentService;
	
//IMPIMPIMPIMPIMP
	//add marks(Math,English,science))IMP
	@PostMapping("/add/{sId}")
	Subject add(@RequestBody Subject subject,@PathVariable int sId) throws Exception {
		service.add(subject);
		Student student = studentService.getById(sId);
		student.setSubject(subject);
		
		studentService.add(student);
		
		
		return subject;
	}
	
	@GetMapping("/get/{id}/{subName}")
	int getMarks(@PathVariable int subId,@PathVariable String subName)throws Exception{
		return service.getMarks(subId, subName);
	}
	
	@GetMapping("/getAll")
	List<Subject> getAllMarks(){
		return service.getAllMarks();
	}
	
	//update marks
	@PutMapping("/update/{subId}")
	String update(@PathVariable int subId,@RequestBody Subject subject)throws Exception{
		return service.update(subId, subject);
	}
	
	//delete marks
	@DeleteMapping("/delete/{subId}")
	String delete(@PathVariable int subId)throws Exception{
		return service.delete(subId);
	}
	
	
	
	//average marks
	@GetMapping("/avg/{subId}")
	String avg(@PathVariable int subId) throws Exception{
	double average = service.avg(subId);
	
	
	try {
		Student	student = studentService.getStudentBySubId(subId);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
			return "Average marks of "+studentService.getStudentBySubId(subId).getsName()+" is  "+average;
	}
	
}
