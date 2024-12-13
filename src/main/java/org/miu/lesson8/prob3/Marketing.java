package org.miu.lesson8.prob3;

import java.util.Objects;

public class Marketing {
	private String employeename;
	private String productname;
	private double salesamount;

	public Marketing(String employeename, String productname, double salesamount) {
		this.employeename = employeename;
		this.productname = productname;
		this.salesamount = salesamount;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getSalesamount() {
		return salesamount;
	}

	public void setSalesamount(double salesamount) {
		this.salesamount = salesamount;
	}

	@Override
	public String toString() {
		return employeename + " " + productname + " " + salesamount;
	}

	public boolean equals(Object obj){
		if(this==obj) return true;
		if(!(obj instanceof Marketing marketing)) return false;
		return marketing.getEmployeename().equals(this.getEmployeename()) &&
				marketing.getProductname().equals(this.getProductname()) &&
						marketing.getSalesamount()==this.getSalesamount();
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeename, productname, salesamount);
	}
}