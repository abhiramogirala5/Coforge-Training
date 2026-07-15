package com.coforge.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
	private int studentId;
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", subjects=" + subjects
				+ ", skills=" + skills + ", marks=" + marks + ", address=" + address + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int studentId, String studentName, List<String> subjects, Set<String> skills,
			Map<String, Integer> marks, Address address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.subjects = subjects;
		this.skills = skills;
		this.marks = marks;
		this.address = address;
	}
	private String studentName;
	private List<String> subjects;
	private Set<String> skills;
	private Map<String,Integer> marks;
	private Address address;
	public int getstudentId() {
		return studentId;
	}
	public void setstudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	public Set<String> getSkills() {
		return skills;
	}
	public void setSkills(Set<String> skills) {
		this.skills = skills;
	}
	public Map<String, Integer> getMarks() {
		return marks;
	}
	public void setMarks(Map<String, Integer> marks) {
		this.marks = marks;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void displayStudentDetails() {
		this.toString();
	}
}
