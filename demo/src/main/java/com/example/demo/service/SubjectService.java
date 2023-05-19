package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Subject;

//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
public interface SubjectService {

	
	
	//add marks(Math,English,science))
	Subject addSubject(Subject subject);
	
	Subject getBySubjectId(int subId) throws Exception;
	
	
	int getMarks(int subId,String subName)throws Exception;
	
	List<Subject> getAllMarks();
	
	//update marks
	String updateSubject(int subId,Subject subject)throws Exception;
	
	//delete marks
	String deleteSubject(int subId)throws Exception;
	
	
	
	//average marks
	double avg(int subId) throws Exception;
	
	//
}
