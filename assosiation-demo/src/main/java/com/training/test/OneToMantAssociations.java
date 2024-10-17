package com.training.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.modal.Cart;
import com.training.modal.Product;
import com.training.util.HibernateUtil;

public class OneToMantAssociations {
	public static void main(String[] args) {
		
		addCart();

	}

	public static void addCart() {
		List<Product> products = Arrays.asList(new Product("TV", 2000), new Product("T-shirt", 5000),
				new Product("Air Freshner", 400));

		Cart cart = new Cart();

		cart.setProducts(products);
		int amount = cart.getAmount();
		cart.setAmount(amount);

		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.persist(cart);

		tx.commit();

		session.close();
		HibernateUtil.closeSessionFactory();
	}

	public static void getCart() {

		Session session = HibernateUtil.getSession();
		Cart getdata = session.get(Cart.class, 2);
		System.out.println(getdata.getId() + "     " + getdata.getAmount());

		List<Product> productList = getdata.getProducts();
		productList.forEach(System.out::println);
	}
}
