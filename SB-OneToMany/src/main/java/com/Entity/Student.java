package com.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

import lombok.Builder;
import lombok.Data;

@Entity
@Data@Table(name = "Student")
@Validated
@Builder
public class Student {

	public Student() {

	}

	
	public Student(int sid, @NotBlank(message = "This field should not blank") String sname, String saddress,
			List<Subject> subjects) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.saddress = saddress;
		this.subjects = subjects;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;

	@NotBlank(message = "This field should not blank")
	private String sname;

	private String saddress;

	@OneToMany(cascade = CascadeType.ALL)
	 List<Subject> subjects = new ArrayList<>();

}
