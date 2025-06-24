package com.Service;

import java.util.Date;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Entity.FileUpload;
import com.Entity.User;
import com.GlobalExceptionHandling.FileNotAvailableCE;
import com.Repository.FileRepo;
import com.Repository.UserRepository;

@Service
public class UserServiceIMPL implements UserService {

	Logger logger = LoggerFactory.getLogger(UserServiceIMPL.class);

	@Autowired
	private UserRepository ur;

	@Autowired
	private JavaMailSender jms;

	@Autowired
	private FileRepo fr;

	@Override
	public int addUserInService(User user) {

		if (user != null) {

			user.setDate(new Date());

			ur.save(user);
			logger.info("User added");

			SimpleMailMessage sms = new SimpleMailMessage();
			sms.setTo("bhalegharesakshi@gmail.com");
			sms.setSubject("Registration completed!!!");
			sms.setText("your User name is :- " + user.getUname() + " " + "Your password is :-" + user.getUpassword()
					+ " Thanks You!!");

			jms.send(sms);

			logger.info("Mail Sended");

		} else {
			logger.warn("User should not be null");
			return 1;
		}
		return 0;
	}

	@Override
	public List<User> getUserFromService() {

		List<User> listUser = ur.findAll();

		return listUser;
	}

	@Override
	public int updateUserInService(User user) {

		if (user != null) {
			ur.save(user);
			logger.info("User added");
		} else {
			logger.warn("User should not be null");
			return 1;
		}
		return 0;

	}

	@Override
	public int deleteUserInService(int id) {

		User user = ur.findById(id).get();

		if (user != null) {
			ur.delete(user);
			logger.info("User deleted");
		} else {
			logger.warn("User should not be null");
			return 1;
		}
		return 0;

	}

	@Override
	public User getUserFromServiceByUsingID(int id) {

		User user = ur.findById(id).get();

		return user;

	}

	@Override
	public void fileHandlingInService(MultipartFile file) {

		if (file != null) {

			try {

				FileUpload fu = new FileUpload();
				fu.setFileName(file.getOriginalFilename());
				fu.setFileRegisterDate(new Date());
				fu.setFileData(file.getBytes());

				fr.save(fu);
				logger.info("File Saved in DB");

				String str = "hfbvn";
				int i1 = Integer.parseInt(str);

			} catch (Exception e) {

				logger.error("File has some issues exception occured" + e.getMessage());
				throw new FileNotAvailableCE("File Not Valid Please Try Again");

			}
		}

	}

}
