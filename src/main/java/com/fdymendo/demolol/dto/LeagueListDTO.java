package com.fdymendo.demolol.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class LeagueListDTO {

	private String leagueId;
	private List<LeagueItemDTO> entries;
	private String tier;
	private String name;
	private String queue;

}