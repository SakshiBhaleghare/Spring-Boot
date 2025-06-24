package com.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

	Optional<Rating> findByUserIdAndStoreId(Long userId, Long storeId);

	List<Rating> findByStoreId(Long storeId);

	List<Rating> findByStoreIdOrderBySubmittedAtDesc(long id);

// <Rating> findByStoreIdOrderBySubmittedAtDesc(Long storeId);
}
