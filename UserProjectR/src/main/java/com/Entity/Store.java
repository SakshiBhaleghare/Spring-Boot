package com.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;

	@Column(nullable = false, length = 60)

	public String name;

	public String email;

	@Column(length = 400)
	public String address;

	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	private List<Rating> ratings;

	public boolean matches(String filter) {
		return name.contains(filter) || email.contains(filter) || address.contains(filter);
	}

}
