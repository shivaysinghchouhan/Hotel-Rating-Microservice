package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.entity.Hotel;
import com.hotel.repository.HotelRepository;
@Service
@Transactional
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel saveHotelDetails(Hotel hotel) {
		return hotelRepository.saveHotelDetails(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.getAllHotels();
	}

	@Override
	public Hotel getHotelDetailsById(Integer hotelId) {
		return hotelRepository.getHotelDetailsById(hotelId);
	}

}
