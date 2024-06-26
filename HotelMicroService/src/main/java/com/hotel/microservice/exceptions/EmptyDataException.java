package com.hotel.microservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmptyDataException extends RuntimeException {
	
	private String errorCode;
	private String errorMessage;

}
