package com.training.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.modal.Person;
import com.training.modal.Vehicle;
import com.training.util.HibernateUtil;

public class PersonTest {
	public static void main(String[] args) {
//		 Vehicle bike = new Vehicle(20091781, 50000, "Bike");
//	        Person amit = new Person("Amit", "9137705219", bike);

	        Session session = HibernateUtil.getSession();
	        Transaction tx = session.beginTransaction();

//	        session.persist(amit); // Hibernate will automatically persist the Vehicle entity

	        Person person = session.get(Person.class,1);
	        System.out.println("person Details");
	        System.out.println("-----------------------");
	        System.out.println(person.getId()+"-"+person.getName()+"-" +person.getContact());

	        Vehicle vehicle = person.getVehicle();
	        System.out.println(vehicle.getRegistrationId()+"-"+vehicle.getType()+"-"+ vehicle.getPrice());
	        tx.commit();
	        session.close();
	        HibernateUtil.closeSessionFactory();
	}
}
