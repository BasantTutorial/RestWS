package com.rest.hibernate.employee.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rest.hibernate.employee.bo.EmployeeBO;
import com.rest.hibernate.employee.util.HibernateUtil;

public class RestEmployeeDAO {

	public void save(EmployeeBO employeeBO) {
		SessionFactory factory = HibernateUtil.getInstance();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(employeeBO);
		tx.commit();
		session.close();
	}
}