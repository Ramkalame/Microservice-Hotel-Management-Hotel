package com.hotel.microservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hotel.microservice.payloads.ApiResponse;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(EmptyDataException.class)
	public ResponseEntity<?> handleEmptyDataException(EmptyDataException ex){
		ApiResponse<Object> response = new ApiResponse<>();
		response.setData(null);
		response.setMessage("Data you want to save hase empty field");
		response.setSuccess(false);
		response.setStatusCode(HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler(NoSuchElementFoundException.class)
	public ResponseEntity<?> handleNoSuchElementFoundException(NoSuchElementFoundException ex){
		ApiResponse<Object> response = new ApiResponse<>();
		response.setData(null);
		response.setMessage("There is no data in the database");
		response.setSuccess(false);
		response.setStatusCode(HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

}
