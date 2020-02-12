package com.arthurvinicius.cursomc.services.exceptions;

public class DataintegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataintegrityException(String msg) {
		super(msg);
	}

	public DataintegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	
}
