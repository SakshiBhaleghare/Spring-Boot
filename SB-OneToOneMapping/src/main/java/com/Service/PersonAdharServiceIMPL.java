package com.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Adhar;
import com.Entity.Person;
import com.Repository.AdharRepository;
import com.Repository.PersonRepository;

@Service
public class PersonAdharServiceIMPL implements PersonAdharService {

	Logger logger = LoggerFactory.getLogger(PersonAdharServiceIMPL.class);

	@Autowired
	private PersonRepository pr;

	@Autowired
	private AdharRepository ar;

	@Override
	public int addPersonWithAdharInService(Person person) {

		if (person != null) {

			pr.save(person);

			logger.info("Person and Adhar added");
			return 1;

		} else {
			logger.warn("Person should not be null");

			return 0;
		}

	}

	@Override
	public Person getPersonDetailsInService(int id) {

		Person person = pr.findById(id).get();

		return person;
	}

	@Override
	public List<Person> getPersonWithAdharInService() {

		return pr.findAll();
	}

	@Override
	public Person getSinglePersonUsingID(int pid) {

		return pr.findById(pid).get();
	}

	@Override
	public int updatePersonInService(Person person) {

		if (person != null) {
			pr.save(person);
			logger.info("User added");
		} else {
			logger.warn("User should not be null");
			return 1;
		}

		return 0;
	}

	@Override
	public int deletePersonDetails(int id) {

		Person person = pr.findById(id).get();

		if (person != null) {
			pr.delete(person);
			logger.info("Person Deleted");
		} else {
			logger.info("Person should not be null");
			return 1;

		}
		return 0;
	}

}
