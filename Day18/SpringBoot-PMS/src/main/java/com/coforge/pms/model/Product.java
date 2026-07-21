package com.coforge.pms.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="tbl_product")
public class Product {
	@Id
	@Column(name="pid" , length=5)
	@NotNull
	private int pid;
	
	@Column(name="pname" , length=100)
	@NotBlank
	private String pname;
	
	@Column(name="pprice" , length=5)
	@Positive
	private double pprice;
	
	@Column(name="pquantity" , length=5)
	@Positive
	private int pquantity;
	public Product(int pid, String pname, double pprice, int pquantity) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.pquantity = pquantity;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", pquantity=" + pquantity + "]";
	}
}
