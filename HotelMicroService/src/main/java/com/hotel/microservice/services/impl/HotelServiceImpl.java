package com.hotel.microservice.services.impl;

import java.util.List;

import com.hotel.microservice.exceptions.EmptyDataException;
import com.hotel.microservice.exceptions.NoSuchElementFoundException;
import com.hotel.microservice.models.Hotel;
import com.hotel.microservice.repositories.HotelRepository;
import com.hotel.microservice.services.HotelService;

public class HotelServiceImpl implements HotelService{
	
	private HotelRepository hotelRepo;

	@Override
	public Hotel createHotel(Hotel hotel) {
		Hotel newHotel = new Hotel();
		if(hotel.getHotelId() != null) {
			newHotel.setHotelId(hotel.getHotelId());
			newHotel.setHotelName(hotel.getHotelName());
			newHotel.setHotelLocation(hotel.getHotelLocation());
			newHotel.setAbout(hotel.getAbout());
			hotelRepo.save(newHotel);
			return newHotel;
		}else {
			throw new EmptyDataException("605", "user id is empty");
		}
		
	}

	@Override
	public List<Hotel> getListOfHotel() {
		
		List<Hotel> listOfHotels =  hotelRepo.findAll();
		if(listOfHotels.size()==0) {
			throw new NoSuchElementFoundException("606", "There is no hotel Available in the database");
		}else {
			
			return listOfHotels;
			
		}
		
	}

	@Override
	public String getHotel(String hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteHotel(String hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

}
