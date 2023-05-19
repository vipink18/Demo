package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student_spring_data")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sId;
	
	private String sName;
	private String sCity;
	private String sMobileNo;
	
	@OneToOne
	private Subject subject;
	
	
	@OneToMany(mappedBy = "student")
	private List<Books> books;

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sCity=" + sCity + ", sMobileNo=" + sMobileNo
				+ ", subject=" + subject + ", books=" + books + "]";
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsCity() {
		return sCity;
	}

	public void setsCity(String sCity) {
		this.sCity = sCity;
	}

	public String getsMobileNo() {
		return sMobileNo;
	}

	public void setsMobileNo(String sMobileNo) {
		this.sMobileNo = sMobileNo;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	public Student(int sId, String sName, String sCity, String sMobileNo, Subject subject, List<Books> books) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sCity = sCity;
		this.sMobileNo = sMobileNo;
		this.subject = subject;
		this.books = books;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
