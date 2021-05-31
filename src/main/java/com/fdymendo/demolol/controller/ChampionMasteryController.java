package com.fdymendo.demolol.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fdymendo.demolol.handler.ApplicationHandler;
import com.fdymendo.demolol.service.IChampionMasteryService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/champion-mastery/v1/")
public class ChampionMasteryController {

	private final IChampionMasteryService iChampionMasteryService;

	@GetMapping("champion-mastery/by-summoner/{encryptedSummonerId}")
	public Mono<Object> bySummoner(@RequestHeader Map<String, String> headers,
			@PathVariable("encryptedSummonerId") String encryptedSummonerId) throws ApplicationHandler {
		return this.iChampionMasteryService.bySummoner(headers, encryptedSummonerId);
	}

	@GetMapping("champion-mastery/by-summoner/{encryptedSummonerId}/by-champion/{championId}")
	public Mono<Object> entriesBySummoner(@RequestHeader Map<String, String> headers,
			@PathVariable("encryptedSummonerId") String encryptedSummonerId,
			@PathVariable("championId") String championId) throws ApplicationHandler {
		return this.iChampionMasteryService.bySummonerByChampion(headers, encryptedSummonerId, championId);
	}

	@GetMapping("scores/by-summoner/{encryptedSummonerId}")
	public Mono<Object> scoreBySummoner(@RequestHeader Map<String, String> headers,
			@PathVariable("encryptedSummonerId") String encryptedSummonerId) throws ApplicationHandler {
		return this.iChampionMasteryService.scoreBySummoner(headers, encryptedSummonerId);
	}
	
}