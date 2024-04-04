package com.hotel.microservice.services;

import java.util.List;

import com.hotel.microservice.models.Hotel;

public interface HotelService {
	
	public Hotel createHotel(Hotel hotel);
	
	public List<Hotel> getListOfHotel();
	
	public String getHotel(String hotelId);
	
	public String deleteHotel(String hotelId);

}
