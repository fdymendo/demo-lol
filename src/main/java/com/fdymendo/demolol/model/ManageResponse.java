package com.fdymendo.demolol.model;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ManageResponse {

	private HttpStatus httpStatus;

	public ManageResponse() {
		this.httpStatus = HttpStatus.BAD_REQUEST;
		
	}
}