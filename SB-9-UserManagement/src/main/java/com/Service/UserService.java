package com.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.Entity.User;

public interface UserService {

	public int addUserInService(User user);

	public List<User> getUserFromService();

	public int updateUserInService(User user);

	public int deleteUserInService(int id);

	public User getUserFromServiceByUsingID(int id);

	public void fileHandlingInService(MultipartFile file);

}
