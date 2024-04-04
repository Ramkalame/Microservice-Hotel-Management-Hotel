package com.hotel.microservice.exceptions;

import java.util.Collection;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.hotel.microservice.models.Hotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NoSuchElementFoundException extends RuntimeException {
	
	
	private String errorCode;
	private String errorMessage;

	

}
