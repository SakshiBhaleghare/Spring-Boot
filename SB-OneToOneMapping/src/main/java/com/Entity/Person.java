package com.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "Person")
@Data
@Validated
@Builder
public class Person {

	public Person() {

	}

	public Person(int pid, @NotBlank(message = "This field should not blank") String pname, String paddress,
			Adhar adharcard) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.paddress = paddress;
		this.adharcard = adharcard;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;

	@NotBlank(message = "This field should not blank")
	private String pname;

	private String paddress;

	@OneToOne(cascade = CascadeType.ALL)
	private Adhar adharcard;

}
