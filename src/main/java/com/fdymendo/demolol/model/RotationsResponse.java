package com.fdymendo.demolol.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class RotationsResponse {

	private String freeChampionIds[];
	private String freeChampionIdsForNewPlayers[];
	private Integer maxNewPlayerLevel;

}