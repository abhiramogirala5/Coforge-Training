package com.coforge.ems.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="tbl_employee")
public class Employee {
	
	@Id
	@Column(name="eid" , length=5)
	@NotNull
	private int eid;
	
	@Column(name="ename" , length=100)
	@NotBlank
	private String ename;
	
	@Column(name="salary" , length=5)
	@Positive
	private int esalary;
	
	@Column(name="dno" , length=5)
	@Positive
	private int dno;

	public Employee() {
		super();
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getEsalary() {
		return esalary;
	}

	public void setEsalary(int esalary) {
		this.esalary = esalary;
	}

	public int getdno() {
		return dno;
	}

	public Employee(int eid, String ename, int esalary, int dno) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esalary = esalary;
		this.dno = dno;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esalary=" + esalary + ", dno=" + dno + "]";
	}

	public void setdno(int dno) {
		this.dno = dno;
	}
}
