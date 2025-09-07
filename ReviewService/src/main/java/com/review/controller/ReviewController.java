package com.review.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.review.entity.Rating;
import com.review.service.ReviewService;

@RestController
@RequestMapping("/api/rating")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;


    @PostMapping("/save-rating")
    public Rating saveRatingDetails(@RequestBody Rating rating) {
        return reviewService.saveRatingDetails(rating);
    }
  

    @GetMapping("/all")
    public List<Rating> getAllRatings() {
        return reviewService.getAllRatings();
    }


    @GetMapping("/getRatingById/{id}")
    public Rating getRatingById(@PathVariable int id) {
        return reviewService.getRatingById(id);
    }
    
    @GetMapping("/getRatingByUserId/{userId}")
    public ArrayList<Rating> getRatingByUserId(@PathVariable int userId) {
        return reviewService.getRatingByUserId(userId);
    }
}
