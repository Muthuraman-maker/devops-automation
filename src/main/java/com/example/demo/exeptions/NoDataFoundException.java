package com.example.demo.exeptions;

public class NoDataFoundException extends RuntimeException{

	public NoDataFoundException(String message) {
		super(message);
	}
}
