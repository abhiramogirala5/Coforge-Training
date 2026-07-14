package com.coforge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_employee")
public class Employee {
	@Id
	@Column(name = "eid" , length = 5)
	private int eid;
	
	@Column(name = "ename" , length = 100)
	private String ename;
	
	@Column(name = "salary" , length = 5)
	private int salary;
	
	@Column(name = "dno" , length = 5)
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

	public int getsalary() {
		return salary;
	}

	public void setsalary(int salary) {
		this.salary= salary;
	}

	public int getdno() {
		return dno;
	}

	public Employee(int eid, String ename, int salary, int dno) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary= salary;
		this.dno = dno;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary+ ", dno=" + dno + "]";
	}

	public void setdno(int dno) {
		this.dno = dno;
	}
}
