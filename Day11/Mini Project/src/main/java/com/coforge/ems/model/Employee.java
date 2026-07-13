package com.coforge.ems.model;

public class Employee {
	private int eid;
	private String ename;
	private int esalary;
	private int don;

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

	public int getDon() {
		return don;
	}

	public Employee(int eid, String ename, int esalary, int don) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esalary = esalary;
		this.don = don;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esalary=" + esalary + ", don=" + don + "]";
	}

	public void setDon(int don) {
		this.don = don;
	}
}
