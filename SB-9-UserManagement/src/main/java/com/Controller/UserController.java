package com.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Multipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.DTO.UserDTO;
import com.DTO.UserDTO2;
import com.Entity.User;
import com.Service.UserService;

@RestController
@RequestMapping("/exponent")
public class UserController {

	@Autowired
	private UserService us;

	Logger logger = LoggerFactory.getLogger(UserController.class);

//	private Object userList;

	@PostMapping("/adduser")
	public ResponseEntity<?> AddUser(@RequestBody User user) {

		logger.info("I am in Controller" + user);

		int result = us.addUserInService(user);

		if (result == 0) {
			return new ResponseEntity("User added successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity("User is null", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/getUsers")
	public ResponseEntity<?> GetUserDetails() {

		List<UserDTO> udtoList = new ArrayList<UserDTO>();

		List<User> userlList = us.getUserFromService();

		for (User user : userlList) {

			UserDTO udto = new UserDTO();

			udto.setUid(user.getUid());
			udto.setUname(user.getUname());
			udto.setUemail(user.getUemail());
			udto.setGender(user.getGender());
			udto.setDate(user.getDate());

			udtoList.add(udto);

		}

		logger.info("UserDTO data:" + udtoList);

		return new ResponseEntity(udtoList, HttpStatus.OK);

	}

	@GetMapping("/getUsersById")
	public ResponseEntity<?> GetUserDetailsById(@RequestParam("uid") int id) {

		User user = us.getUserFromServiceByUsingID(id);

		UserDTO2 udto2 = new UserDTO2();

		udto2.setUemail(user.getUemail());
		udto2.setGender(user.getGender());

		logger.info("UserDTO data:" + udto2);

		if (user != null) {
			return new ResponseEntity(udto2, HttpStatus.OK);
		} else {
			return new ResponseEntity("User is null", HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@PutMapping("/updateUser")
	public ResponseEntity<?> UpdateUserDetailsUsingID(@RequestBody User user) {

		int result = us.updateUserInService(user);

//		int result = us.addUserInService(user);

		if (result == 0) {
			return new ResponseEntity("User updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity("User is null", HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@DeleteMapping("/deleteUser")
	public ResponseEntity<?> deleteUserByID(@RequestParam("uid") int id) {

		int result = us.deleteUserInService(id);

		if (result == 0) {
			return new ResponseEntity("User deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity("User is null", HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@PostMapping("/dummycall")
	public ResponseEntity<?> DummyCall() {

		String str = null;

		System.out.println(str.toLowerCase());

		System.out.println("line1");
		System.out.println("line2");

		return new ResponseEntity("code working fine", HttpStatus.OK);
	}

	@PostMapping("/file")
	public ResponseEntity<?> fileHandling(@RequestPart MultipartFile file) {

		logger.info("file name is:" + file.getOriginalFilename());

		us.fileHandlingInService(file);
		return new ResponseEntity("File Uploaded", HttpStatus.OK);

	}

}
