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

public class PasswordController {

	@Autowired
	private UserService userService;

	@PutMapping("/update-password")
	public ResponseEntity<?> updatePassword(@RequestBody PasswordUpdateRequestDTO request) {
		return userService.updatePassword(request);
	}

	public static String encode(String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean matches(Object password, String password2) {
		// TODO Auto-generated method stub
		return false;
	}
}
