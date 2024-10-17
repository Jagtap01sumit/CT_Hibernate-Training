package com.citiustech.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.citiustech.model.Customer;
import com.citiustech.model.Vendor;
import com.training.util.HibernateUtil;

public class ManyToManyAssociation {
	public static void main(String[] args) {
		
		save();
		fetchCustomer();
		HibernateUtil.closeSessionFactory();

	}
	public static void save() {
		Customer customer1 = new Customer();
		customer1.setName("Sumit");
		customer1.setAddress("Kamothe");
		
		Customer customer2 = new Customer();
		customer2.setName("Amit");
		customer2.setAddress("Pune");
		
		
		
		Vendor vendor1 = new Vendor();
		vendor1.setNamej("Synergetic");
		vendor1.setAddress("Andheri");
		
		Vendor vendor2 = new Vendor();
		vendor2.setNamej("Vinsys");
		vendor2.setAddress("Pune");
		
		
		customer1.setVendors(Arrays.asList(vendor1,vendor2));
		customer2.setVendors(Arrays.asList(vendor1,vendor2));
		
		vendor1.setCustomers(Arrays.asList(customer1,customer2));
		vendor2.setCustomers(Arrays.asList(customer1,customer2));
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.persist(customer1);
		session.persist(customer2);
		
		tx.commit();
		session.close();


	}
	
	public static void fetchCustomer() {
		
		
		Session session = HibernateUtil.getSession();
		Customer customer = session.get(Customer.class, 125443959);
		
		System.out.println(customer.getName()+"   " + customer.getAddress());
		List<Vendor> vendor = customer.getVendors();
		System.out.println("Vendor details -> ");
		vendor.forEach(ven -> System.out.println(ven.getNamej() + "        " + ven.getAddress())); // by dault its lazy loading
		
		session.close();
	}
}
