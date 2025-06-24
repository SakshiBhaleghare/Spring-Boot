package com.DTO;

import java.time.LocalDateTime;

import com.Entity.Store;
import com.Entity.User;

import lombok.Data;

@Data
public class UserDTO {

	private String userName;
	private String userEmail;
	private int ratingValue;
	private LocalDateTime submittedAt;

}
