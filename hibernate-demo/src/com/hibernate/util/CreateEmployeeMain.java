package com.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Employee;

public class CreateEmployeeMain {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {
			// create the employee object
			System.out.println("Create the new Employee objects.");
			Employee emp = new Employee("Paul","Doe","paul@varsity.com");
			// start a transaction
			session.beginTransaction();
			// save the employee object
			System.out.println("Saving the employee...");
			session.save(emp);
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done.");
		}finally {
			factory.close();
		}		
	}
}
