package com.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.DTO.LoginRequestDTO;
import com.DTO.PasswordUpdateRequestDTO;
import com.Entity.User;

public interface UserService {

	void addUser(User user);

	List<User> getAllUsers();

	ResponseEntity<?> updatePassword(PasswordUpdateRequestDTO request);

	ResponseEntity<?> login(LoginRequestDTO request);

	ResponseEntity<?> signup(User user);
}
