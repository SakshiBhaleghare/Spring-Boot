package com.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/")
	public String getMsg() {

		logger.info("Hello we are in getMsg() method");
		logger.info("Good Morning");
		logger.info("Success");

		logger.error("error occured");
		
		logger.warn("exception can be occured");

		logger.debug("debug mode activated");

		logger.trace("i am in trace mode");

		return "Hello Batch";

	}

}
