package com.Controller;

import com.Entity.Student;

public class HomeController {

	public static void main(String[] args) {

		Student s = new Student();
		s.setId(101);
		s.setName("Sakshi");

		System.out.println(s);
	}
}
