package com.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/api/user")//api/user/get-user/userId
public class UserController {
	
	@Autowired
	private UserService userService;
	

    private static final Logger logger = LoggerFactory.getLogger(UserController.class); 
	 
	   @PostMapping("/save-user")
	    public ResponseEntity<User> saveUserDetails(@RequestBody User user) {
	        User savedUser = userService.saveUserDetails(user);
	        return ResponseEntity.ok(savedUser);
	    }
	   
	   @GetMapping("/get-users")
	    public ResponseEntity<List<User>> getAllUser() {
	        List<User> listOfUser = userService.getAllUser();
	        return ResponseEntity.ok(listOfUser);
	    }
	   
	  /* Integer count = 1;
	   @GetMapping("/get-user/{userId}")
	   @Retry(name="ratingHotelService", fallbackMethod="ratingHotelFall")
	   @RateLimiter(name = "userRateLimiter", fallbackMethod = "userRateLimiterFallback")
	   public ResponseEntity<User> getUserDetailsById(@PathVariable Integer userId) {
	       count++;
	       logger.info("Service retry Count: {}", count);
	       User userDetails = userService.getUserDetailsByUserId(userId);
	       return ResponseEntity.ok(userDetails);
	   }

	   public ResponseEntity<User> ratingHotelFall(@PathVariable Integer userId, Throwable ex) {
	       logger.info("Fallback is executed because service is down: {}", ex.getMessage());

	       User user = User.builder()
	               .emailId("dummy@gmail.com")
	               .userName("dummy")
	               .aboutUser("This user is created as fallback because some service is down.")
	               .userId(1234)
	               .build();

	       return new ResponseEntity<>(user, HttpStatus.OK);
	   }*/
	   
	   
	   @GetMapping("/get-user/{userId}")
	    @RateLimiter(name = "userRateLimiter", fallbackMethod = "userRateLimiterFallback")
	    public ResponseEntity<User> getUserDetailsById(@PathVariable Integer userId) {
	        logger.info("Fetching user details for userId: {}", userId);
	        User userDetails = userService.getUserDetailsByUserId(userId);
	        return ResponseEntity.ok(userDetails);
	    }

	    // ✅ Fallback method for RateLimiter
	    public ResponseEntity<User> userRateLimiterFallback(@PathVariable Integer userId, Throwable ex) {
	        logger.warn("Rate limiter fallback triggered for userId {}: {}", userId, ex.getMessage());

	        User user = User.builder()
	                .emailId("dummy@gmail.com")
	                .userName("RateLimit User")
	                .aboutUser("Fallback: Too many requests. Please try again later.")
	                .userId(0)
	                .build();

	        return new ResponseEntity<>(user, HttpStatus.TOO_MANY_REQUESTS);
	    }

}
