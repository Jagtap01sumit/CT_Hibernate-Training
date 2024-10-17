package com.citiustech.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="vendors")
public class Vendor {
	@Id
	@Column(name="vendor_id")
	@GenericGenerator(name="my-id-generator", strategy = "com.citiustech.model.CustomIdGenerator")
	@GeneratedValue(generator ="my-id-generator")
	private int id;
	private String namej;
	private String address;
	@ManyToMany
	private List<Customer> customers;
	
}
