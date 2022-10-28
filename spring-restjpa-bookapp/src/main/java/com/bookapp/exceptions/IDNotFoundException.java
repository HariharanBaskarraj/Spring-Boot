package com.bookapp.exceptions;

public class IDNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IDNotFoundException() {
		super();
	}

	public IDNotFoundException(String message) {
		super(message);
	}

}
