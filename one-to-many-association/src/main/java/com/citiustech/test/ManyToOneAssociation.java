package com.citiustech.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.citiustech.model.Cart;
import com.citiustech.model.Product;
import com.training.util.HibernateUtil;

public class ManyToOneAssociation {
	public static void main(String [] args) {
		
		addProduct();
		
		HibernateUtil.closeSessionFactory();
		
	}
	public static void addProduct() {
		Product p1 = new Product("T-Shirt", 10000);
		Product p2 = new Product("Air-Freshner",20000);
		Product p3 = new Product("Car", 13500000);
		
		
		Cart cart = new Cart();
		p1.setCart(cart);
		p2.setCart(cart);
		p3.setCart(cart);
		
		int total= p1.getPrice()+ p2.getPrice() + p3.getPrice();
		cart.setAmount(total);
		
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.persist(p1);
		session.persist(p2);
		session.persist(p3);
		
		tx.commit();
		session.close();
				
	}
}
