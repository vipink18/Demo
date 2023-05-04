package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_spring_data")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sId;
	
	private String sName;
	private String sCity;
	private String sMobileNo;
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
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sCity=" + sCity + ", sMobileNo=" + sMobileNo + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
