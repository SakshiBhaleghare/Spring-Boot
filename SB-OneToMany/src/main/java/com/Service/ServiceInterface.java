package com.Service;

import java.util.List;

import com.Entity.Student;

public interface ServiceInterface {

	public int addStudentWithSubjectsInService(Student student);

	public List<Student> getAllStudents();

	public Student getStudentByID(int id);

	public int updateStudent(Student student);

	public int deleteStudent(int id);

}
