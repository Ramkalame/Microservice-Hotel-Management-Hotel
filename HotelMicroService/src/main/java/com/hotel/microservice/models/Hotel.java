package com.hotel.microservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
@Entity
@Table(name = "hotel")
public class Hotel {
	
	@Id
	private String hotelId;
	private String hotelName;
	private String hotelLocation;
	private String about;

}
