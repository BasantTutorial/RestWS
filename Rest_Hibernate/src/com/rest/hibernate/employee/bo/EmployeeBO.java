package com.rest.hibernate.employee.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.FormParam;

@Entity
@Table(name = "EMP_REST2")
public class EmployeeBO {
	@Id
	@Column(name = "EMP_ID")
	private int empId;
	@Column(name = "EMP_NAME")
	private String name;
	@Column(name = "DEPT")
	private String dept;
	@Column(name = "SAL")
	private double salary;

	@Override
	public String toString() {
		return "EmployeeBO [empId=" + empId + ", name=" + name + ", dept="
				+ dept + ", salary=" + salary + "]";
	}

	public EmployeeBO(int empId, String name, String dept, double salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}

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
