package com.fdymendo.demolol.handler;

import java.io.Serializable;

public class ApplicationHandler extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7170706873975765324L;

	public ApplicationHandler(String message, Exception e) {
		super(message, e);
	}

	public ApplicationHandler(String message) {
		super(message);
	}
}