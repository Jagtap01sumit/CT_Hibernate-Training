package com.citiustech.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.citiustech.model.Cart;
import com.citiustech.model.Product;
import com.training.util.HibernateUtil;

public class ManyToOneAssociation {
	public static void main(String[] args) {

		addCart();
		fetchCart();
		fetchProduct();
		HibernateUtil.closeSessionFactory();

	}

	public static void addCart() {
		Product p1 = new Product("Phone", 10000);
		Product p2 = new Product("T-shirt", 200);
		Product p3 = new Product("Car", 47378292);

		Cart cart = new Cart();
		p1.setCart(cart);
		p2.setCart(cart);
		p3.setCart(cart);

		List<Product> products = Arrays.asList(p1, p2, p3);
		cart.setProducts(products);
		cart.setAmount(cart.getAmount());

		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.persist(cart);

		tx.commit();
		session.close();
	}

	public static void fetchCart(){
		Session session = HibernateUtil.getSession();
		Cart cart = session.get(Cart.class,29);

		System.out.println(cart.getId()+ "-"+ cart.getAmount());
		List<Product> products = cart.getProducts();
		products.forEach(product -> System.out.println(product.getId()+ "-" +product.getName()));

		session.close();
		}

	public static void fetchProduct() {
		Session session = HibernateUtil.getSession();
		Product product = session.get(Product.class, 30);
		System.out.println(product.getId() + "-" + product.getName());
		Cart cart = product.getCart();
		System.out.println(cart.getId() + "-" + cart.getAmount());
	}

}
