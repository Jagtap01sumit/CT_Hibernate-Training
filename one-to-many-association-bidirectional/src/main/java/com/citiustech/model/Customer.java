package com.citiustech.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;


@Entity
@Data
@Table(name="customers")
public class Customer {
	@Id
	@Column(name="customer_id")
	@GenericGenerator(name="my-id-generator", strategy = "com.citiustech.model.CustomIdGenerator")
	@GeneratedValue(generator ="my-id-generator")
	private int id;
	private String name;
	private String address;
	@ManyToMany(cascade = CascadeType.PERSIST,mappedBy = "customers")
	private List<Vendor> vendors;
}
