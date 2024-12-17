package com.ak.Hibernate_OnetoOne_mapping.Controller;

import java.time.LocalDate;

import com.ak.Hibernate_OnetoOne_mapping.Dao.PersonAdharDao;
import com.ak.Hibernate_OnetoOne_mapping.Entity.Aadhar;
import com.ak.Hibernate_OnetoOne_mapping.Entity.Person;

public class InsertPersonAdharController {

	
	public static void main(String[] args) {
		PersonAdharDao adharDao = new PersonAdharDao() ;
		
		//Aadhar adhar = new Aadhar(101, "ak", "LKO", LocalDate.parse("2000-12-20"));
		
		//Person person = new Person(124, "Max", "max@gmail.com", adhar);
		
		//adharDao.saveAdharDao(adhar);
		
		//adharDao.savePersonAdharDao(person, adhar);
		//adharDao.savePersonDao(person, 101);
		
		Person p1 = adharDao.getPersonAdharByPersonId(124);
		System.out.println(p1);
				
	}
}
