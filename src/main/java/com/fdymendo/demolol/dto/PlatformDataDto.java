package com.fdymendo.demolol.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class PlatformDataDto {

	private String id;
	private String name;
	private List<String> locales;
	private List<StatusDto> maintenances;
	private List<StatusDto> incidents;

}