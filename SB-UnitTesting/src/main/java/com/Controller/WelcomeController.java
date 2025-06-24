package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.WelcomeService;

@RestController
public class WelcomeController {

	@Autowired
	public WelcomeService ws;

	@GetMapping("/welcome")
	public String getMsg() {

		return ws.getMsgInService();
	}
}
