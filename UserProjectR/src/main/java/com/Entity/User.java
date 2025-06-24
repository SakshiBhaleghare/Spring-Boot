package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 60)

	public String name;

	@Column(unique = true, nullable = false)

	public String email;

	@Column(nullable = false)
	public String password;

	@Column(length = 400)
	public String address;

	@Enumerated(EnumType.STRING)
	private Role role = Role.NORMAL_USER;

	public boolean matches(String filter) {
		return name.contains(filter) || email.contains(filter) || address.contains(filter)
				|| role.name().contains(filter);
	}

	public User(String name2, String email2, String password2, String address2, Role role2) {
		// TODO Auto-generated constructor stub
	}
}
