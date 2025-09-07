package com.review.repository;

import java.util.ArrayList;
import java.util.List;

import com.review.entity.Rating;

public interface ReviewRepository {
	 public Rating saveRatingDetails(Rating rating);
	 public List<Rating> getAllRatings();
	 public Rating getRatingById(int id);
	 public ArrayList<Rating> getRatingByUserId(int userId);
}
