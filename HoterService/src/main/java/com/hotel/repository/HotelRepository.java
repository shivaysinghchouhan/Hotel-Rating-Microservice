package com.hotel.repository;

import java.util.List;

import com.hotel.entity.Hotel;

public interface HotelRepository {
	
	public Hotel saveHotelDetails(Hotel hotel);
	public List<Hotel> getAllHotels();
	public Hotel getHotelDetailsById(Integer hotelId);

}
