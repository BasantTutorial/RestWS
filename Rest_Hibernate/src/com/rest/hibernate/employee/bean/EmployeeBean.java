package com.rest.hibernate.employee.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.ws.rs.FormParam;

public class EmployeeBean {

	@FormParam("id")
	private int empId;

	@FormParam("name")
	private String name;

	@FormParam("dept")
	private String dept;

	@FormParam("salary")
	private double salary;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
