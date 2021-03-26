package com.ixia.round2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EventException extends RuntimeException {

	private static final long serialVersionUID = 8834403177920244626L;

	public EventException(){
		// TODO Auto-generated constructor stub
		super("not found");
	}
	
	public EventException(String resourceName,String value) {
		super("Could not find event with "+resourceName+" = "+value);
	}

}
