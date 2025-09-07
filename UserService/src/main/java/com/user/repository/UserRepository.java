package com.user.repository;

import java.util.List;

import com.user.entity.User;

public interface UserRepository {
	
	public User saveUserDetails(User user);
	public List<User> getAllUser();
	public User getUserDetailsByUserId(Integer userId);

}
