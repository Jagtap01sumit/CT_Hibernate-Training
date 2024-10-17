package com.citiustech.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cart")
@NoArgsConstructor
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private int id;
	private double amount;
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "cart")
	private List<Product> products;

	public Cart(double amount, List<Product> products) {
		super();
		this.amount = amount;
		this.products = products;

	}

	public int getAmount() {
		int total = 0;
		for (Product product : products) {
			total += product.getPrice();

		}
		return total;
	}
}
