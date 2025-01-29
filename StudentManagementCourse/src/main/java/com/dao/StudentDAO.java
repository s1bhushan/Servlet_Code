package com.dao;

import java.util.List;

import com.model.Student;

public interface StudentDAO {
	

	int saveStudent(Student student);
	int deleteStudent(Student student);
	int deleteStudentByrollno(int id);
	int updateStudent(Student student);
	List<Student>getAllStudent();
	Student getStudentById(int id);


}
