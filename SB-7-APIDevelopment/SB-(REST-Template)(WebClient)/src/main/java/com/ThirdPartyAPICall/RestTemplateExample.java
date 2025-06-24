package com.ThirdPartyAPICall;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Entity.User;

@RestController
public class RestTemplateExample {

	@GetMapping("/getdetailsFromAPI")
	public ResponseEntity<?> getCallFromAPI() {

//      Step 1: hardcode the url

		String url = "https://jsonplaceholder.typicode.com/posts";

//      Step 2: create rest template object

		RestTemplate rt = new RestTemplate();

//      Step 3: create the call (GET,POST,DELETE,PUT)

		// ResponseEntity<String> result = rt.getForEntity(url, String.class);

		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(MediaType.APPLICATION_JSON);

		HttpEntity<Object> entity = new HttpEntity<>(headers);

		ResponseEntity<String> result = rt.exchange(url, HttpMethod.GET, entity, String.class);

//      Step 4: take data from respective method

		String body = result.getBody();

//		String body = rt.getForObject(url, String.class);

		return new ResponseEntity(body, HttpStatus.OK);

	}

	/*
	 * @PostMapping("/postData") public ResponseEntity<?>
	 * postCallFromAPI(@RequestBody User user) {
	 * 
	 * String url = "http://localhost:8005/exponent/adduser";
	 * 
	 * RestTemplate rt = new RestTemplate();
	 * 
	 * ResponseEntity<String> result = rt.postForEntity(url, user, String.class);
	 * 
	 * String body = result.getBody();
	 * 
	 * return new ResponseEntity(body, result.getStatusCode());
	 * 
	 * }
	 */

	@PostMapping("/postData")
	public ResponseEntity<?> postCallFromAPI() {

		String url = "http://localhost:8005/exponent/adduser";

		RestTemplate rt = new RestTemplate();

		User user = new User();
		user.setUname("ram");
		user.setGender("M");
		user.setUemail("ram@1234");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity entity = new HttpEntity(user);

		ResponseEntity<String> result = rt.exchange(url, HttpMethod.POST, entity, String.class);

		String body = result.getBody();

		return new ResponseEntity(body, result.getStatusCode());

	}

	@GetMapping("/getUser")
	public ResponseEntity<?> getUserCall() {

		String url = "http://localhost:8005/exponent/getUsers";

		RestTemplate rt = new RestTemplate();

		ResponseEntity<String> result = rt.getForEntity(url, String.class);

		String body = result.getBody();

		return new ResponseEntity(body, HttpStatus.OK);

	}

	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUserDetails(@RequestBody User user) {

		String url = "http://localhost:8005/exponent/updateUser";

		RestTemplate rt = new RestTemplate();

		rt.put(url, user);

		return new ResponseEntity("updated", HttpStatus.OK);
	}

	@DeleteMapping("/deleteUserDetails/{id}")
	public ResponseEntity<?> deleteUserCall(@PathVariable int id) {

		String url = "http://localhost:8005/exponent/deleteUser?uid=" + id;

		RestTemplate rt = new RestTemplate();

		rt.delete(url, id);

		return new ResponseEntity("Deleted", HttpStatus.OK);
	}
}
