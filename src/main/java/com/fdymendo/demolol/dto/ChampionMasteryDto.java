package com.fdymendo.demolol.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ChampionMasteryDto {

	private long championPointsUntilNextLevel;
	private boolean chestGranted;
	private long championId;
	private long lastPlayTime;
	private int championLevel;
	private String summonerId;
	private int championPoints;
	private long championPointsSinceLastLevel;
	private int tokensEarned;
	
}