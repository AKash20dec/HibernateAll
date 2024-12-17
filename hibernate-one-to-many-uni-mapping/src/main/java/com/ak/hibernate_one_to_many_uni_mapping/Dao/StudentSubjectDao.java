package com.ak.hibernate_one_to_many_uni_mapping.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ak.hibernate_one_to_many_uni_mapping.entity.Student;
import com.ak.hibernate_one_to_many_uni_mapping.entity.Subject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class StudentSubjectDao {

	EntityManager em =Persistence.createEntityManagerFactory("hibernate").createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public Student saveStudentSubjectDao(Student student, List<Subject> subjects) {
		
		try {
			et.begin();
			for (Subject subject : subjects) {
				em.persist(subject);
			}
			
			em.persist(student);
			et.commit();
			
			return student;
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Subject> saveSubjectDao(List<Subject> subjects,int studentId) {
		try {
			et.begin();
			for (Subject subject : subjects) {
				em.persist(subject);
				Query query = em.createNativeQuery("insert into student_subject(Student_id,subject_id) values(?,?)");
				query.setParameter(1, studentId);
				query.setParameter(2, subject.getId());
				query.executeUpdate();
				et.commit();
			}
			et.commit();
			
			return subjects;
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	public boolean deleteSubjectBySubjectIdDao(List<Integer> subjectId) {
		
		String deleteSubjectQuery = "DELETE FROM student_subject WHERE subjects_id=?";
		et.begin();
		boolean b= false;
		
		for (Integer id : subjectId) {
			
			em.createNativeQuery(deleteSubjectQuery).setParameter(1, id).executeUpdate();
			
			Subject subject = em.find(Subject.class, id);
			
			if(subject!=null) {
				em.remove(subject);
				b= true;
			}else {
				b=false;
			}
		}
		et.commit();
		return b;
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudentDao(){
		return em.createQuery("from Student").getResultList();
		
	}
	public List<Student> filterStudentBySubjectName(String subjectName){
		List<Student> students = getAllStudentDao();
		
		//List<Subject> subjects = new ArrayList<Subject>();
		
		return students 
				.stream()
				.filter(a->a.getSubjects().stream()
						.anyMatch(a1->a1.getName()
								.equalsIgnoreCase(subjectName))).collect(Collectors.toList());
		
		
	}
}
