package com.ak.hibernate_one_to_many_uni_mapping.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int id;
	private String name;
	private String email;
	
	@OneToMany
	private List<Subject> subjects;
	
	public Student(String name, String email, List<Subject> subjects) {
		super();
		this.name = name;
		this.email = email;
		this.subjects = subjects;
	}
	
}
