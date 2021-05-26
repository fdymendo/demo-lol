package com.fdymendo.demolol.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class CurrentGameInfo {

	private long gameId;
	private String gameType;
	private long gameStartTime;
	private long mapId;
	private long gameLength;
	private String platformId;
	private String gameMode;
	private List<BannedChampion> bannedChampions;
	private long gameQueueConfigId;
	private Observer observers;
	private List<CurrentGameParticipant> participants;

}