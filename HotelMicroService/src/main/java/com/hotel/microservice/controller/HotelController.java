package com.hotel.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.microservice.exceptions.EmptyDataException;
import com.hotel.microservice.exceptions.NoSuchElementFoundException;
import com.hotel.microservice.models.Hotel;
import com.hotel.microservice.payloads.ApiResponse;
import com.hotel.microservice.services.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	
	@Autowired
	private HotelService hotelService;
	
	
	@PostMapping("/add-hotel")
	public ResponseEntity<?> addHotel(@RequestBody Hotel hotel){
		try {
			Hotel newHotel = hotelService.createHotel(hotel);
			ApiResponse<Object> response = new ApiResponse<Object>(newHotel, "New Hotel is created", true, HttpStatus.OK);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}catch(EmptyDataException ex) {
			ApiResponse<Object> response = new ApiResponse<Object>(null, ex.getMessage(), true, HttpStatus.BAD_REQUEST);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
	}
	
	@GetMapping("/get-hotel-list")
	public ResponseEntity<?> getHotelList(){
		
		try {
			List<Hotel> listOfHotel =   hotelService.getListOfHotel();
			ApiResponse<Object> response = new ApiResponse(listOfHotel, "this is your hotel list", true, HttpStatus.OK);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}catch(NoSuchElementFoundException ex) {
			
			ApiResponse<Object> response = new ApiResponse(null, ex.getMessage(), true, HttpStatus.NOT_FOUND);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
			
		}
		
	}

}
