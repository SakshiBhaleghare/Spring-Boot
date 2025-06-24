package com.DTO;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
public class UserDTO {

	private int uid;

	private String uname;

	private String uemail;

	private String gender;

	@Temporal(TemporalType.DATE)
	private Date date;

}
