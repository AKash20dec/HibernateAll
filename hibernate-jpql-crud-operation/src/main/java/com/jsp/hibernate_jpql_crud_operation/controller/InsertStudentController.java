package com.jsp.hibernate_jpql_crud_operation.controller;

import java.time.LocalDate;

import com.jsp.hibernate_jpql_crud_operation.dao.StudentDao;
import com.jsp.hibernate_jpql_crud_operation.dto.Student;

public class InsertStudentController {

	public static void main(String[] args) {
		
		StudentDao dao = new StudentDao();
		
	Student student = new Student(868632, "Virat", "virat1234@gmail.com",675676, LocalDate.parse("2023-09-09"));
		
		dao.saveStudentDao(student);
		
//		dao.updateStudentNameDao("Mukesh",321456);
		
//		dao.deleteStudentByIdDao(321456);
		
		//dao.getStudentByNameDao(868632);
	}
}
