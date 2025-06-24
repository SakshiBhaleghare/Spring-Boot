package com.DTO;

import lombok.Data;

@Data
public class LoginRequestDTO {

	private String email;
	private String password;

	public Object getPassword() {

		return null;
	}

	public String getEmail() {

		return null;
	}
}
