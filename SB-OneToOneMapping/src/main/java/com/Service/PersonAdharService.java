package com.Service;

import java.util.List;

import com.Entity.Adhar;
import com.Entity.Person;

public interface PersonAdharService {

	public int addPersonWithAdharInService(Person person);

	public Person getPersonDetailsInService(int id);

	public List<Person> getPersonWithAdharInService();

	public Person getSinglePersonUsingID(int pid);

	public int updatePersonInService(Person person);

	public int deletePersonDetails(int id);

}
