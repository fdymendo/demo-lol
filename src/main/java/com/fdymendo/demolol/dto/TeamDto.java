package com.fdymendo.demolol.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class TeamDto {

	private String id;
	private int tournamentId;
	private String name;
	private int iconId;
	private int tier;
	private String captain;
	private String abbreviation;
	private List<PlayerDto> players;

}