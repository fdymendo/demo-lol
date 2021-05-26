package com.fdymendo.demolol.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Participant {

	private boolean bot;
	private long spell2Id;
	private long profileIconId;
	private String summonerName;
	private long championId;
	private long teamId;
	private long spell1Id;

}