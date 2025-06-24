package com.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Entity.Rating;
import com.Repository.RatingRepository;

@Service
public class RatingServiceIMPL implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;

	public Rating submitRating(Rating rating) {
		rating.setTimestamp(LocalDateTime.now());
		return ratingRepository.save(rating);
	}

	public List<Rating> getRatingsForStore(Long storeId) {
		return ratingRepository.findByStoreId(storeId);
	}

	@Override
	public List<Object> getAllRatings() {

		return null;
	}

	@Override
	public ResponseEntity<?> submitRating(RatingRepository ratingRequest) {
		// TODO Auto-generated method stub
		return null;
	}
}
