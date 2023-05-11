package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Subject;
import com.example.demo.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired //
	private SubjectRepository repo;
	
	@Override
	public Subject add(Subject subject) {
		Subject s = repo.save(subject);
		System.out.println(" added ");
		return s;
	}

	@Override
	public String update(int subId, Subject subject) throws Exception {
		repo.findById(subId).orElseThrow( () -> new Exception("Id not found"));
		
		//repo.save(s);
		repo.save(subject);
		return " Data has been updated ";
	}

	@Override
	public String delete(int subId)throws Exception {
		repo.findById(subId).orElseThrow( () -> new Exception("Id not found"));
		return " Data of a particuar Student has been deleted "+subId;
	}

	@Override
	public double avg(int subId)throws Exception {
		repo.findById(subId).orElseThrow( () -> new Exception("Id not found"));
		
		Subject avgsub = repo.findById(subId).get();
		
		double avg = (  avgsub.getEnglish() + avgsub.getEnglish() + avgsub.getScience() )/3;
		
		return avg;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public int getMarks(int subId, String subName) throws Exception {
		repo.findById(subId).orElseThrow( () -> new Exception("Id not found"));
		Subject sub = repo.findById(subId).get();
		
		
		if(subName.equals(sub.getEnglish())) {
			return sub.getEnglish();
		}
		else if(subName.equals(sub.getMaths())) {
			return sub.getMaths();
		}
		else if(subName.equals(sub.getEnglish())) {
			return sub.getEnglish();
		}
		
		return 0;
	}

	@Override
	public List<Subject> getAllMarks() {
		
		return repo.findAll();
	}

	@Override
	public Subject getById(int subId) throws Exception{
		return repo.findById(subId).orElseThrow( ()-> new Exception("No such id"+subId+" found"));
//		return null;
	}

}
