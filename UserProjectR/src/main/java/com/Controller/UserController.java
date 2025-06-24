package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.PasswordUpdateRequestDTO;
import com.Service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PutMapping("/update-password")
	public ResponseEntity<?> updatePassword(@RequestBody PasswordUpdateRequestDTO request) {
		return userService.updatePassword(request);
	}
}
