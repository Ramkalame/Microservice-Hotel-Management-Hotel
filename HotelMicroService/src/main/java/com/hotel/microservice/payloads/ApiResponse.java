package com.hotel.microservice.payloads;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ApiResponse<T> {
	
	private T data;
	private String message;
	private boolean success;
	private HttpStatus statusCode;
	

}
