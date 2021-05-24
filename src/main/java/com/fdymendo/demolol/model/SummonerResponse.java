package com.fdymendo.demolol.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class SummonerResponse {

	private String accountId;
	private Integer profileIconId;
	private Long revisionDate;
	private String name;
	private String id;
	private String puuid;
	private Long summonerLevel;

}