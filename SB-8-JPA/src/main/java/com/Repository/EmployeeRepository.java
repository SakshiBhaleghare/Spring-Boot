package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findByRole(String role);

	public List<Employee> findBySalaryLessThan(double salary);

//	public List<Employee> findBySalaryOrderByLastnameDesc();

	
	/*
	 * @Query(value = "from Employee") public List<Employee> getAllEmployees();
	 */

	@Query(value = "select * from employee", nativeQuery = true)
	public List<Employee> getAllEmployees();

	@Query(value = "select * from employee where ename like 's%' ", nativeQuery = true)
	public List<Employee> rStartEmployee();

	/*
	 * @Modifying
	 * 
	 * @Query(value = "update Employee set ename:name where eid:id") public void
	 * updateNameById(String name, int i);
	 */

}
