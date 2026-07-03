package com.coforge.day3;

public class Student {
	private int sId;
	private String sName;
	private String semail;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getSemail() {
		return semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", semail=" + semail + "]";
	}

}
