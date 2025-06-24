package com.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Student;
import com.Repository.StudentRepository;
import com.Repository.SubjectRepository;

@Service
public class ServiceIMPL implements ServiceInterface {

	Logger logger = LoggerFactory.getLogger(ServiceIMPL.class);

	@Autowired
	public StudentRepository sr;

	@Autowired
	public SubjectRepository subr;

	@Override
	public int addStudentWithSubjectsInService(Student student) {

		if (student != null) {
			sr.save(student);

			logger.info("Student & Subjects added");
			return 1;

		} else {
			logger.warn("Student & Subjects should not be null");
			return 0;
		}

	}

	@Override
	public List<Student> getAllStudents() {

		return sr.findAll();
	}

	@Override
	public Student getStudentByID(int id) {

		Student student = sr.findById(id).get();

		return student;

	}

	@Override
	public int updateStudent(Student student) {

		if (student != null) {

			sr.save(student);
			logger.info("Student added");

		} else {
			logger.warn("Student should not be null");
			return 1;
		}

		return 0;
	}

	@Override
	public int deleteStudent(int id) {

		Student student = sr.findById(id).get();

		if (student != null) {
			sr.delete(student);
			logger.info("Student Deleted");
		} else {
			logger.info("Student should not be null");
			return 1;
		}

		return 0;
	}

}
