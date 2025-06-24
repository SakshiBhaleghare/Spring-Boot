package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Table(name = "Subjects")
@Validated
@Builder
public class Subject {

	public Subject() {

	}

	public Subject(int subId, String subName) {
		super();
		this.subId = subId;
		this.subName = subName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subId;

	private String subName;

}
