package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Controller.PasswordController;
import com.DTO.LoginRequestDTO;
import com.DTO.PasswordUpdateRequestDTO;
import com.Entity.Role;
import com.Entity.User;
import com.Repository.UserRepository;

@Service
public class UserServiceIMPL implements UserService {

	@Autowired
	public UserRepository userRepository;

	public ResponseEntity<?> signup(User user) {
		if (userRepository.findByEmail(user.getEmail()).isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already in use");
		}
		user.setPassword(PasswordController.encode(user.getPassword()));
		user.setRole(Role.NORMAL_USER);
		userRepository.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("User registered");
	}

	public ResponseEntity<?> login(LoginRequestDTO request) {
		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));

		if (!PasswordController.matches(request.getPassword(), user.getPassword())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		}

		// Generate JWT token here
		return ResponseEntity.ok("JWT_TOKEN");
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updatePassword(PasswordUpdateRequestDTO request) {
		// TODO Auto-generated method stub
		return null;
	}

}
