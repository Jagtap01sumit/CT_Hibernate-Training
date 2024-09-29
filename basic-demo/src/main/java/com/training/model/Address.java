package com.training.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
	//passport doesnot exist without person
	private String street ;
	private String city;
	private String state;
	private String country;
	private int zipcode;
}
