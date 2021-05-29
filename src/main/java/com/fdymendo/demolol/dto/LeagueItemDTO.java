package com.fdymendo.demolol.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class LeagueItemDTO {

	private boolean freshBlood;
	private int wins;
	private String summonerName;
	private MiniSeriesDTO miniSeries;
	private boolean inactive;
	private boolean veteran;
	private boolean hotStreak;
	private String rank;
	private int leaguePoints;
	private int losses;
	private String summonerId;
	
}