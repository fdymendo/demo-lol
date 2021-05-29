package com.fdymendo.demolol.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class MiniSeriesDTO {

	private int losses;
	private String progress;
	private int target;
	private int wins;

}