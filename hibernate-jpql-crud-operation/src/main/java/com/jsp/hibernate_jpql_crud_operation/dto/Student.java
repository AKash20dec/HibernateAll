package com.jsp.hibernate_jpql_crud_operation.dto;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "deleteQuery",query = "DELETE FROM Student s WHERE s.id=:id")
@NamedQuery(name = "getStudentByName", query = "select s from Student s where s.id=?1")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	private String email;
	private long phone;
	private LocalDate dob;
	
	
}
