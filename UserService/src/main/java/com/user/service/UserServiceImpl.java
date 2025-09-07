package com.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.user.dto.Hotel;
import com.user.entity.Rating;
import com.user.entity.User;
import com.user.external.services.HotelService;
import com.user.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private HotelService hotelService;
    
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUserDetails(User user) {
        return userRepository.saveUserDetails(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public User getUserDetailsByUserId(Integer userId) {
        User obj = userRepository.getUserDetailsByUserId(userId);

        String ratingUrl = "http://RATING-SERVICE/api/rating/getRatingByUserId/" + userId;
        Rating[] ratingArray = restTemplate.getForObject(ratingUrl, Rating[].class);

        List<Rating> ratingList = Arrays.stream(ratingArray)
            .map(rating -> {
               // String hotelUrl = "http://HOTEL-SERVICE/api/hotel/get-hotel/" + rating.getHotelId();
                Hotel hotel = hotelService.getHotel(rating.getHotelId());//restTemplate.getForObject(hotelUrl, Hotel.class);
               rating.setHotel(hotel);
                return rating;
            })
            .collect(Collectors.toList());

        obj.setListOfRating(ratingList);

        return obj;
    }

}
