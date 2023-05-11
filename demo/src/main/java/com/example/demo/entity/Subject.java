package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject_table")

public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subId;
	
	private int maths;
	private int english;
	private int science;
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public int getMaths() {
		return maths;
	}
	public void setMaths(int maths) {
		this.maths = maths;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getScience() {
		return science;
	}
	public void setScience(int science) {
		this.science = science;
	}
	@Override
	public String toString() {
		return "Subject [subId=" + subId + ", maths=" + maths + ", english=" + english + ", science=" + science + "]";
	}
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
