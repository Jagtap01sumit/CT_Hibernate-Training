package com.training.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	@Column(name="customer_id")
	private int id;
	private String name;
	private String contact;
	@ElementCollection(fetch=FetchType.EAGER) //when we only use @ElementCollection  -> its allow lazy loading -> when we print data only that time it hit address db.
	//when we use @ElementCollection(fetch=FetchType.EAGER) -> ITS EAGER loading -> when we call the customer db then it also hit address db.
	@JoinTable(name="addresses",joinColumns=@JoinColumn(name="customer_id"))
	private List<Address> addresses;
}
