package com.training.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="persons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	@Id
	@Column(name="person_id")
	private int id;
	private String name;
	private String contact;
	@Embedded
	private Address address;

}
