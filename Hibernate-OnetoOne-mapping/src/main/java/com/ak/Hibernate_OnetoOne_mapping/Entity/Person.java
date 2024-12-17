package com.ak.Hibernate_OnetoOne_mapping.Entity;

import java.io.Serializable;


import jakarta.persistence.Entity;

import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String name;
	private String email;
	
	@OneToOne
	private Aadhar aadhar;

	public Person(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	
	

}
