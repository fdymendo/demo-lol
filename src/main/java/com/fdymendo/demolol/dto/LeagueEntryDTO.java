package com.fdymendo.demolol.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class LeagueEntryDTO {
	
	private String leagueId;
	private String summonerId;
	private String summonerName;
	private String queueType;
	private String tier;
	private String rank;
	private String leaguePoints;
	private int wins;
	private int losses;
	private boolean hotStreak;
	private boolean veteran;
	private boolean freshBlood;
	private boolean inactive;
	private MiniSeriesDTO miniSeries;
	
}