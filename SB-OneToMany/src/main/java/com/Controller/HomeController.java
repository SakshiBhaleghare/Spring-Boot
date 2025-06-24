package com.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.StudentDTO;
import com.Entity.Student;
import com.Service.ServiceInterface;

@RestController
public class HomeController {

	@Autowired
	private ServiceInterface si;

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@PostMapping("/addStudentDetails")
	public ResponseEntity<?> addStudentWithSubjects(@Valid @RequestBody Student student) {

		int result = si.addStudentWithSubjectsInService(student);

		if (result == 1) {
			return new ResponseEntity("Student and Subjects added successfully", HttpStatus.OK);

		} else {
			return new ResponseEntity("Student is null", HttpStatus.NOT_ACCEPTABLE);

		}

	}

	@GetMapping("/getStudentWithSubjects")
	public List<Student> getAllStudents() {

		List<Student> allStudent = si.getAllStudents();

		return allStudent;

	}

	@GetMapping("/getStudentById/{id}")
	public Student getStudentByID(@PathVariable("id") int sid) {

		return si.getStudentByID(sid);

	}

	@PutMapping("/updateStudentById")
	public ResponseEntity<?> updateStudent(@RequestBody Student student) {

		int result = si.updateStudent(student);

		if (result == 0) {
			return new ResponseEntity("Student updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity("Student is null", HttpStatus.NOT_ACCEPTABLE);

		}

	}

	@DeleteMapping("/deleteStudentById")
	public ResponseEntity<?> deleteStudent(@RequestParam("sid") int id) {

		int result = si.deleteStudent(id);

		if (result == 0) {
			return new ResponseEntity("Student deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity("Student is null", HttpStatus.NOT_ACCEPTABLE);
		}

	}
}
