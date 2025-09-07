package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.Hotel;
import com.hotel.service.HotelService;

@RestController
@RequestMapping(value = "/api/hotel")//api/hotel/get-hotel/{hotelId}
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping(value="/save-hotel")
	public Hotel saveHotelDetails(@RequestBody Hotel hotel) {
		Hotel obj = hotelService.saveHotelDetails(hotel);
		return obj;
	}
	
	
    @GetMapping("/all-hotels")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

  
    @GetMapping("/get-hotel/{hotelId}")
    public Hotel getHotelById(@PathVariable Integer hotelId) {
        return hotelService.getHotelDetailsById(hotelId);
    }

}
