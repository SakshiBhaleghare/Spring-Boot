package com.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Employee;

@RestController
public class HomeController {

	@GetMapping("/welcome")
	public String getMsg() {
		return "Hi Good Morning";

	}

	@GetMapping("/getinput")
	public String getParameters(@RequestParam("username") String us, @RequestParam("password") String ps) {
		System.out.println("Username is : " + us);
		System.out.println("Password is : " + ps);

		return us + " " + ps;
	}

	// getinputparam /username /password
	@GetMapping("/getinputparam/{username}/v1/{password}")
	public String getPathParameter(@PathVariable("username") String us, @PathVariable("password") String ps) {

		return us + " " + ps;
	}

	@GetMapping("/getalldata")
	public Employee getAllData(@RequestBody Employee emp) {

		System.out.println(emp);

		// jackson data binder
		// json to object - serialization
		// object to json - dserialization

		return emp;
	}
}