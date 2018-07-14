package com.rest.hibernate.employee.util;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;

	private HibernateUtil() {

	}

	@SuppressWarnings("deprecation")
	public synchronized static SessionFactory getInstance() {
		if (factory == null) {
			Configuration conf = new Configuration();
			conf.configure("com/hibernate/config/hibernate.cfg.xml");
			factory = conf.buildSessionFactory();
		}
		return factory;
	}

}
