package com.training.test;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.model.Address;
import com.training.model.Person;
import com.training.util.HibernateUtil;

public class TestPerson {
	
	public static void main(String[] args) {
		
	
	
	Address address = new Address("kamothe", "Mumbai", "mumbai", "India", 410209);
	Person person = new Person(101, "Sumit","+9133705219", address);
	
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();
	
	session.persist(person);
	tx.commit();
	session.close();
	HibernateUtil.closeSessionFactory();
	
	}
	
}