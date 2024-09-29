package com.training.test;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.model.Address;
import com.training.model.Customer;
import com.training.util.HibernateUtil;

public class TestCustomer {
	public static void main(String[] args) {
		
		ArrayList<Address> addresses = new ArrayList<>();
		addresses.add(new Address("MG road", "Mumbai", "Maharastra", "India", 42820));
		addresses.add(new Address("FC road","Pune","Maharastra","India",18278));
		
		Customer customer = new Customer(101,"sumit","81777192791",addresses);
		
		
		Session session = HibernateUtil.getSession();
		
		Customer gcustomer = session.get(Customer.class, 101);
		System.out.println(gcustomer.getId()+"-> Id"+gcustomer.getName()+"-> name"+gcustomer.getContact()); //it not hit the address table
		
		System.out.println("-------------------------------------");
		gcustomer.getAddresses().stream().forEach(System.out::println); // it hit the address table and get data, when we print the data only that time it hit the db , otherwies it just create and obj not fill the all address value; -> this is called lazy loading
		Transaction tx = session.beginTransaction();
		
		session.save(customer);
		tx.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		
		
		}
}
