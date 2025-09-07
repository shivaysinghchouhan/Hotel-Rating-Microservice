package com.review.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.review.entity.Rating;
import com.review.repository.ReviewRepository;
@Service
@Transactional
public class ReviewServiceImpl implements ReviewService{
	
    
	@Autowired
	private ReviewRepository reviewRepository;
	
	
	@Override
	public Rating saveRatingDetails(Rating rating) {
		return reviewRepository.saveRatingDetails(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return reviewRepository.getAllRatings();
	}

	@Override
	public Rating getRatingById(int id) {
		return reviewRepository.getRatingById(id);
	}

	@Override
	public ArrayList<Rating> getRatingByUserId(int userId) {
		return reviewRepository.getRatingByUserId(userId);
	}

}
