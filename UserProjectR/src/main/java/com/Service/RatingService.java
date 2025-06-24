package com.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.Entity.Rating;
import com.Repository.RatingRepository;

public interface RatingService {

	List<Object> getAllRatings(); // Assume rating is an object

	ResponseEntity<?> submitRating(RatingRepository ratingRequest);

	List<Rating> getRatingsForStore(Long storeId);

	Rating submitRating(Rating rating);
}
