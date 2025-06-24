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
@Table(name = "Adhar")
@Data
@Validated
@Builder
public class Adhar {

	public Adhar() {

	}

	public Adhar(int aid, String adharno) {
		super();
		this.aid = aid;
		this.adharno = adharno;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	private String adharno;

}
