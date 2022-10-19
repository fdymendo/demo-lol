package com.fdymendo.demolol.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class TournamentDto {

	private int id;
	private int themeId;
	private String nameKey;
	private String nameKeySecondary;
	private List<TournamentPhaseDto> schedule;

}