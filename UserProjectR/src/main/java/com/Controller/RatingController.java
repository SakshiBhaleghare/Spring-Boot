package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Rating;
import com.Repository.RatingRepository;
import com.Service.RatingService;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@PostMapping
	public ResponseEntity<Rating> submitRating(@RequestBody Rating rating) {
		// Validate rating (1 to 5) here if needed
		Rating savedRating = ratingService.submitRating(rating);
		return new ResponseEntity<>(savedRating, HttpStatus.CREATED);
	}

	@GetMapping("/store/{storeId}")
	public List<Rating> getRatingsByStore(@PathVariable Long storeId) {
		return ratingService.getRatingsForStore(storeId);
	}

	@PostMapping("/submit")
	public ResponseEntity<?> submitRating(@RequestBody RatingRepository ratingRequest) {
		return ratingService.submitRating(ratingRequest);
	}

}
