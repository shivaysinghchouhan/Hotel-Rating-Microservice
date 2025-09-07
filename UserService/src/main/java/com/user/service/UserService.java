package com.user.service;

import java.util.List;


import com.user.entity.User;

public interface UserService {
	public User saveUserDetails(User user); 
	public List<User> getAllUser();
	public User getUserDetailsByUserId(Integer userId);

}
