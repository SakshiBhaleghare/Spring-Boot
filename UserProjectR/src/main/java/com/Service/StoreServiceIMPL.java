package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.DTO.UserDTO;
import com.Entity.DashboardResponse;
import com.Entity.Rating;
import com.Entity.Store;
import com.Entity.User;
import com.Repository.RatingRepository;
import com.Repository.StoreRepository;
import com.Repository.UserRepository;

@Service
public class StoreServiceIMPL {

	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public StoreRepository storeRepository;
	
	@Autowired
	public RatingRepository ratingRepository;
	
	
	public void getOwnerDashboard(String email) {
	    User owner = userRepository.findByEmail(email)
	        .orElseThrow(() -> new UsernameNotFoundException("Owner not found"));

	    Store store = storeRepository.findById(owner.getId())
	        .orElseThrow(() -> new RuntimeException("Store not found"));

	    List<Rating> ratings = ratingRepository.findByStoreIdOrderBySubmittedAtDesc(store.getId());

	    double average = ratings.stream()
	        .mapToInt(Rating::getRatingValue)
	        .average().orElse(0.0);

		
		
		/*
		 * List<UserDTO> userRatings = ratings.stream() .map(r -> new UserRatingDTO(
		 * r.getUser().getName(), r.getUser().getEmail(), r.getRatingValue(),
		 * r.getSubmittedAt() )).toList();
		 * 
		 * 
		 * return new DashboardResponse(store.getName(), average, userRatings);
		 */
		 
	}

}
