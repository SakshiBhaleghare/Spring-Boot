package com;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.Entity.Employee;
import com.Repository.EmployeeRepository;

@SpringBootApplication
public class Sb8JpaApplication {

	@Autowired
	private static SessionFactory sf;

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Sb8JpaApplication.class, args);

		// Employee emp = run.getBean(Employee.class);
		EmployeeRepository er = run.getBean(EmployeeRepository.class);

		Employee e1 = new Employee();
		e1.setEname("sakshi");
		e1.setRole("SE");
		e1.setSalary(55000);
		e1.setEaddress("Pune");

		Employee e2 = new Employee();
		e2.setEname("nikita");
		e2.setRole("JD");
		e2.setSalary(54000);
		e2.setEaddress("Satara");

		Employee e3 = new Employee();
		e3.setEname("shamal");
		e3.setRole("PD");
		e3.setSalary(2000);
		e3.setEaddress("Mumbai");

		Employee e4 = new Employee();
		e4.setEname("shruti");
		e4.setRole("T");
		e4.setSalary(3033);
		e4.setEaddress("Nagpur");

		// er.saveAll(Arrays.asList(e1, e2, e3, e4));

		// System.out.println("Data inserted");

		/*
		 * Iterable<Employee> findAll = er.findAll(); for (Employee employee : findAll)
		 * { System.out.println(employee); }
		 */

		/*
		 * Iterable<Employee> only12 = er.findAllById(Arrays.asList(1,2)); for(Employee
		 * employee : only12) { System.out.println(employee); }
		 */

		/*
		 * Optional<Employee> emp = er.findById(12); System.out.println(emp);
		 */

		// er.deleteAll(Arrays.asList(e1, e2));

		// er.deleteAllById(Arrays.asList(1,2));

		// er.existsById(2);

		// er.count();

		/*
		 * List<Employee> content = er.findAll(PageRequest.of(1, 2)).getContent(); for
		 * (Employee employee : content) { System.out.println(employee); }
		 */

		/*
		 * List<Employee> sortedEmployees = er.findAll(Sort.by("salary").ascending());
		 * for (Employee employee : sortedEmployees) { System.out.println(employee); }
		 */

		/*
		 * List<Employee> allSE = er.findByRole("SE"); for (Employee employee : allSE) {
		 * System.out.println(employee); }
		 */

		/*
		 * List<Employee> allLTFty = er.findBySalaryLessThan(50000); for (Employee
		 * employee : allLTFty) { System.out.println(employee); }
		 */

		List<Employee> employees = er.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee);
		}

		System.out.println("-----------------");

		List<Employee> rEmployees = er.rStartEmployee();
		for (Employee employee : rEmployees) {
			System.out.println(employee);
		}

		/*
		 * List<Employee> salaryDesc = er.findBySalaryOrderByLastnameDesc(); for
		 * (Employee employee : employees) { System.out.println(employee); }
		 */
	}
}
