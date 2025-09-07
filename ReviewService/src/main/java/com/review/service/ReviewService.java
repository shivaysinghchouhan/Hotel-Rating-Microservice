package com.review.service;

import java.util.ArrayList;
import java.util.List;

import com.review.entity.Rating;

public interface ReviewService {
	 public Rating saveRatingDetails(Rating rating);
	 public List<Rating> getAllRatings();
	 public Rating getRatingById(int id);
	 public ArrayList<Rating> getRatingByUserId(int userId);
}
