package com.training.modal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "persons")
@NoArgsConstructor
public class Person {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="person_id")
	private int id;
	private String name;
	private String contact;
	@OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)//when we add person obj then the vehile obj also saved
	@JoinColumn(name = "vehicle_registration_id")
	private Vehicle vehicle;
	
	
	public Person(String name , String contact , Vehicle vehicle) {
		this.name= name;
		this.contact=contact;
		this.vehicle=vehicle;
	}
}
