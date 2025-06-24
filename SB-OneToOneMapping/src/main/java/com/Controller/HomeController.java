package com.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.PersonDTO;
import com.Entity.Adhar;
import com.Entity.Person;
import com.Repository.PersonRepository;
import com.Service.PersonAdharService;

import lombok.Builder;

@RestController
public class HomeController {

	@Autowired
	private PersonAdharService pas;

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@PostMapping("/addPersonDetails")
	public ResponseEntity<?> addPersonWithAdhar(@Valid @RequestBody Person person) {

		int result = pas.addPersonWithAdharInService(person);

		if (result == 1) {
			return new ResponseEntity("Person and adhar added successfully", HttpStatus.OK);

		} else {
			return new ResponseEntity("User is null", HttpStatus.NOT_ACCEPTABLE);
		}

	}

	// without creating DTO
	/*
	 * @GetMapping("/getPersonDetailsByID") public ResponseEntity<?>
	 * getPersonDetails(@RequestParam("pid") int id) {
	 * 
	 * Person person = pas.getPersonDetailsInService(id);
	 * 
	 * person.setPid(person.getPid()); person.setPname(person.getPname());
	 * person.setPaddress(person.getPaddress());
	 * person.setAdharcard(person.getAdharcard());
	 * 
	 * logger.info("Person added:" + person);
	 * 
	 * if (person != null) { return new ResponseEntity(person, HttpStatus.OK); }
	 * else { return new ResponseEntity("Person is null",
	 * HttpStatus.NOT_ACCEPTABLE); }
	 * 
	 * }
	 */

	// using DTO

	/*
	 * @GetMapping("/getPersonWithAdhar") public ResponseEntity<?>
	 * getPersonWithAdhar() {
	 * 
	 * List<Person> allperson = pas.getPersonWithAdharInService();
	 * 
	 * List<PersonDTO> dtoList = new ArrayList<PersonDTO>();
	 * 
	 * for (Person person : allperson) { PersonDTO dto = new PersonDTO();
	 * dto.setPname(person.getPname());
	 * dto.setAdharNo(person.getAdharcard().getAdharno());
	 * 
	 * dtoList.add(dto);
	 * 
	 * }
	 * 
	 * return new ResponseEntity(dtoList, HttpStatus.OK);
	 * 
	 * }
	 */

	@GetMapping("/getSinglePerson/{id}")
	public ResponseEntity<?> getSinglePerson(@PathVariable("id") int pid) {

		Person sperson = pas.getSinglePersonUsingID(pid);

		PersonDTO result = PersonDTO.builder().adharNo(sperson.getAdharcard().getAdharno()).pname(sperson.getPname())
				.build();

		return new ResponseEntity(result, HttpStatus.OK);

	}

	@PutMapping("/updatePersonByID")
	public ResponseEntity<?> updatePerson(@RequestBody Person person) {

		int result = pas.updatePersonInService(person);

		if (result == 0) {
			return new ResponseEntity("Person updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity("Person is null", HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@DeleteMapping("/deletePersonByID")
	public ResponseEntity<?> deletePerson(@RequestParam("pid") int id) {

		int result = pas.deletePersonDetails(id);

		if (result == 0) {
			return new ResponseEntity("Person deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity("Person is null", HttpStatus.NOT_ACCEPTABLE);
		}

	}
}
