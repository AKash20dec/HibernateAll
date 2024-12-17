package com.jsp.hibernate_jpql_crud_operation.dao;

import com.jsp.hibernate_jpql_crud_operation.dto.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class StudentDao {

	EntityManager em = Persistence.createEntityManagerFactory("hibernate").createEntityManager();
	EntityTransaction et = em.getTransaction();

	// native query also known as sql query
	String insertStudentQuery = "insert into student (id,name,email,phone,dob) values(?,?,?,?,?)";

	// this is positional parameter query
	// String jpqlUpdateStudentNameQuery = "update Student s set s.name=?1 where
	// s.id=?2";

	// this is named parameter query
	String jpqlUpdateStudentNameQuery = "update Student s set s.name=:abc where s.id=:xyz";

	public Student saveStudentDao(Student student) {

		Query query = em.createNativeQuery(insertStudentQuery, Student.class);
		query.setParameter(1, student.getId());
		query.setParameter(2, student.getName());
		query.setParameter(3, student.getEmail());
		query.setParameter(4, student.getPhone());
		query.setParameter(5, student.getDob());
		et.begin();
		int a = query.executeUpdate();
		et.commit();
		System.out.println(a + "no of row affected");

		return student;
	}

	public int updateStudentNameDao(String name, int id) {

		Query query = em.createQuery(jpqlUpdateStudentNameQuery);

		query.setParameter("abc", name);
		query.setParameter("xyz", id);

		et.begin();
		int a = query.executeUpdate();
		et.commit();
		System.out.println(a + "no of row affected");

		return a;
	}

	public int deleteStudentByIdDao(int id) {

		Query query = em.createNamedQuery("deleteQuery");

		query.setParameter("id", id);

		et.begin();
		int a = query.executeUpdate();
		et.commit();
		System.out.println(a + "no of row deleted");

		return a;
	}

	public Object getStudentByNameDao(int id) {

		Query query = em.createNamedQuery("getStudentByName");

		query.setParameter(1, id);

		Object object = query.getSingleResult();  // Execute the query
		 // Check if the result is of type Student
	    if (object instanceof Student) {
	        Student student = (Student) object;
	        System.out.println(student);  // Log or process the Student
	        return student;  // Return the actual Student object
	    } else {
	        // Handle the case where the result is not a Student (optional)
	        return null;  // Or throw an exception if it's an unexpected result
	    }
	}

}
