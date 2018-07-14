package com.rest.hibernate.employee.service;

import com.rest.hibernate.employee.bo.EmployeeBO;
import com.rest.hibernate.employee.dao.RestEmployeeDAO;

public class EmployeeService {

	public String save(EmployeeBO employeeBO) {
		RestEmployeeDAO dao = new RestEmployeeDAO();
		dao.save(employeeBO);
		return "Record Saved Successfully : ";
	}
}
