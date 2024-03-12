package com.full.app.Exception;


import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class userAleradyExsitsException extends RuntimeException {

	
	public userAleradyExsitsException(String message) {
		super(message);
	}
	
}
