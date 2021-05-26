package com.fdymendo.demolol.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class FeaturedGameInfo {

	private String gameMode;
	private long gameLength;
	private long mapId;
	private String gameType;
	private List<BannedChampion> bannedChampions;
	private long gameId;
	private Observer observers;
	private long gameQueueConfigId;
	private long gameStartTime;
	private List<Participant> participants;
	private String platformId;

}