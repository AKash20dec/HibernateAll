package com.ak.Hibernate_OnetoOne_mapping.Entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="adhar")
public class Aadhar implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "adharno",length =12,updatable = false)
	private long aadharNumber;
	@Column(name="fathername",length=30)
	private String fatherName;
	private String address;
	private LocalDate dob;
	
}
