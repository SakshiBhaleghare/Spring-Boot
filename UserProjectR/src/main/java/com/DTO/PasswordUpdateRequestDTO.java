package com.DTO;

import lombok.Data;

@Data
public class PasswordUpdateRequestDTO {

	private String oldPassword;
	private String newPassword;

}
