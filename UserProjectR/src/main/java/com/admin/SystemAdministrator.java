package com.admin;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RestController;

import com.DTO.StoreDTO;
import com.DTO.UserDTO;
import com.Entity.Role;
import com.Entity.Store;
import com.Entity.User;
import com.Service.RatingService;
import com.Service.StoreService;
import com.Service.UserService;

@RestController
public class SystemAdministrator {

	private UserService userService;
	private StoreService storeService;
	private RatingService ratingService;

	public SystemAdministrator(String name, String email, String password, String address, UserService userService,
			StoreService storeService, RatingService ratingService) {
		super();
		this.userService = userService;
		this.storeService = storeService;
		this.ratingService = ratingService;
	}

	// Add new store
	public void addStore(Store store) {
		storeService.addStore(store);
	}

	// Add new user (normal or admin)
	public void addUser(String name, String email, String password, String address, Role role) {
		User user = new User(name, email, password, address, role);
		userService.addUser(user);
	}

	// Dashboard metrics
	public int getTotalUsers() {
		return userService.getAllUsers().size();
	}

	public int getTotalStores() {
		return storeService.getAllStores().size();
	}

	public int getTotalRatings() {
		return ratingService.getAllRatings().size();
	}

	// View list of stores
	/*
	 * public List<StoreDTO> viewStores(String filter) { return
	 * storeService.getAllStores().stream().filter(store ->
	 * store.matches(filter)).map(StoreDTO::fromStore)
	 * .collect(Collectors.toList()); }
	 */

	// View list of users
	/*
	 * public List<UserDTO> viewUsers(String filter) { return
	 * userService.getAllUsers().stream().filter(user ->
	 * user.matches(filter)).map(UserDTO::fromUser) .collect(Collectors.toList()); }
	 */
	// Log out
	public void logout() {
		System.out.println("Logged out.");
		// Clear session or auth token
	}
}
