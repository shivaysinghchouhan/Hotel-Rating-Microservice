package com.hotel.service;

import java.util.List;

import com.hotel.entity.Hotel;

public interface HotelService {
	
	public Hotel saveHotelDetails(Hotel hotel);
	public List<Hotel> getAllHotels();
	public Hotel getHotelDetailsById(Integer hotelId);

}
