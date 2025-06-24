package com.Entity;

import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import lombok.Data;

//@Entity
@Data
public class User {

//	@Id

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;

	private String uname;

	private String uemail;

	private String upassword;

	private String uaddress;

	private String gender;

//	@Temporal(TemporalType.DATE)
	private Date date;

}


