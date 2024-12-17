package com.ak.Hibernate_OnetoOne_mapping.Dao;

import com.ak.Hibernate_OnetoOne_mapping.Entity.Aadhar;
import com.ak.Hibernate_OnetoOne_mapping.Entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersonAdharDao {
	
	
	EntityManager em =Persistence.createEntityManagerFactory("hibernate").createEntityManager();
	EntityTransaction et = em.getTransaction();
	public Person savePersonAdharDao(Person person, Aadhar adhar) {
		
		try {
			et.begin();
			em.persist(adhar);
			em.persist(person);
			et.commit();
			
			return person;
			
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Aadhar saveAdharDao(Aadhar adhar) {
		
		try {
			et.begin();
			em.persist(adhar);
			et.commit();
			return adhar;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Person savePersonDao(Person person,long adharNumber) {
		
		
		Aadhar adhar =em.find(Aadhar.class, adharNumber);
		
		if(adhar!=null) {
			try {
				person.setAadhar(adhar);
				et.begin();
				em.persist(person);
				et.commit();
				return person;
			} catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}
	
public Person getPersonAdharByPersonId(int personId) {
		
		
		Person person =em.find(Person.class, personId);
		
		if(person!=null) {
			return person;
		} else {
			return null;
		}
	}
	
	
}
