package com.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int ratingValue; // Should be 1 to 5

	@ManyToOne
	private User user;

	@ManyToOne
	private Store store;

	private LocalDateTime timestamp;

	public Object getSubmittedAt() {
		// TODO Auto-generated method stub
		return null;
	}

}
