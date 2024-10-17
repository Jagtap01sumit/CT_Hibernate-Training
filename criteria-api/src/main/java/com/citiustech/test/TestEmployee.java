package com.citiustech.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.citiustech.model.Employee;
import com.training.util.HibernateUtil;

public class TestEmployee {
	public static void main(String[] args) {
		addEmployee();
		
		HibernateUtil.closeSessionFactory();

	}
	public static void addEmployee() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(new Employee("sumit", "IT", 1000000));
		session.save(new Employee("amit", "HR", 1000000));
		session.save(new Employee("suresh", "System Engineer", 1000000));
		session.save(new Employee("ramesh", "Security", 1000000));
		session.save(new Employee("amit", "AWS", 1000000));
		session.save(new Employee("kiran", "IT", 1000000));
		session.save(new Employee("rohen", "IT", 1000000));
		
		tx.commit();
		session.close();
	}
}
