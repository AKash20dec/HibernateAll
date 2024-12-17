package com.ak.hibernate_one_to_many_uni_mapping.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ak.hibernate_one_to_many_uni_mapping.Dao.StudentSubjectDao;
import com.ak.hibernate_one_to_many_uni_mapping.entity.Student;
import com.ak.hibernate_one_to_many_uni_mapping.entity.Subject;

public class InsertStudentSubjectController {

	public static void main(String[] args) {
		
		StudentSubjectDao dao = new StudentSubjectDao();
		
//		Subject subject1 = new Subject("JAVA", "JAMES");
//		Subject subject2 = new Subject("SQL", "RAYMOND");
//		Subject subject3 = new Subject("JS", "BREDEN");
//		
//		List<Subject> subjects = new ArrayList<Subject>(Arrays.asList(subject1,subject2,subject3));
//		
//		Student student1= new Student("AKash","ak@gmail.com",subjects);
//		
//		dao.saveStudentSubjectDao(student1, subjects);
		
//		dao.saveSubjectDao(subjects, 1);
//		
//		boolean b= dao.deleteSubjectBySubjectIdDao(new ArrayList<Integer>(Arrays.asList(1235,1236)));
//		
//		String msg =b?"deleted": "given id is not found";
//		System.out.println(msg);
		
		List<Student> students = dao.filterStudentBySubjectName("java");
		
		Set<Student> students2 = new HashSet<Student>(students);
		for (Student student : students2) {
			System.out.println(student.getName());
		}
	}
}
