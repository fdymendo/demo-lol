package com.fdymendo.demolol.handler;

import java.io.Serializable;

public class ErrorClass extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7170706873975765324L;

	public ErrorClass(String message, Exception e) {
		super(message, e);
	}

	public ErrorClass(String message) {
		super(message);
	}
}