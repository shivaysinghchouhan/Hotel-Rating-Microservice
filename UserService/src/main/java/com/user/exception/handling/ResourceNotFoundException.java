package com.user.exception.handling;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	ResourceNotFoundException(){
		super("Resource Not Found on server!!");
	}
	
	ResourceNotFoundException(String message){
		super(message);
	}

}
