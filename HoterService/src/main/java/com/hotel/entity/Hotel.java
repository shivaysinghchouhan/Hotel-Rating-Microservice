package com.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="hotel",schema="hotel_microservice")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="hotel_id")
	private Integer hotelId;
	@Column(name="hotel_name")
	private String hotelName;
	@Column(name="hotel_location")
	private String hotelLocation;
	@Column(name="about_hotel")
	private String aboutHotel;
public String getHotelName() {
	return hotelName;
}
public void setHotelName(String hotelName) {
	this.hotelName = hotelName;
}
public String getHotelLocation() {
	return hotelLocation;
}
public void setHotelLocation(String hotelLocation) {
	this.hotelLocation = hotelLocation;
}
public String getAboutHotel() {
	return aboutHotel;
}
public void setAboutHotel(String aboutHotel) {
	this.aboutHotel = aboutHotel;
}
public Integer getHotelId() {
	return hotelId;
}
public void setHotelId(Integer hotelId) {
	this.hotelId = hotelId;
}

}
