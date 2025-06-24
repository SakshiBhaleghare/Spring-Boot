package com;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Endpoint(id="cendpoint")
public class CustomEndpoints {

	@ReadOperation
	public String getEndpoint() {
		
		return "Welcome to custom endpoint";
		
	}
	
	
	
}
