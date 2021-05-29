package com.fdymendo.demolol.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fdymendo.demolol.handler.ApplicationHandler;
import com.fdymendo.demolol.service.ILeagueService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/league/v1/lol/league/v4")
public class LeagueController {

	private final ILeagueService iLeagueService;

	public LeagueController(ILeagueService iLeagueService) {
		this.iLeagueService = iLeagueService;
	}

	@GetMapping("/challengerleagues/by-queue")
	public Mono<Object> challengerLeagueByQueue(@RequestHeader Map<String, String> headers,
			@RequestParam("queue") String queue) throws ApplicationHandler {
		return this.iLeagueService.challengerLeaguesByQueue(headers, queue);
	}

	@GetMapping("/entries/by-summoner")
	public Mono<Object> entriesBySummoner(@RequestHeader Map<String, String> headers,
			@RequestParam("encryptedSummonerId") String encryptedSummonerId) throws ApplicationHandler {
		return this.iLeagueService.entriesBySummoner(headers, encryptedSummonerId);
	}

	@GetMapping("/entries")
	public Mono<Object> entries(@RequestHeader Map<String, String> headers, @RequestParam("queue") String queue,
			@RequestParam("tier") String tier, @RequestParam("division") String division,
			@RequestParam("page") int page) throws ApplicationHandler {
		return this.iLeagueService.entries(headers, queue, tier, division, page);
	}


	@GetMapping("/grandmasterleagues/by-queue")
	public Mono<Object> grandMasterByQueue(@RequestHeader Map<String, String> headers,
			@RequestParam("queue") String queue) throws ApplicationHandler {
		return this.iLeagueService.grandmasterLeaguesByQueue(headers, queue);
	}
	
	@GetMapping("/leagues")
	public Mono<Object> leagues(@RequestHeader Map<String, String> headers, @RequestParam("leagueId") String leagueId)
			throws ApplicationHandler {
		return this.iLeagueService.leagues(headers, leagueId);
	}
	@GetMapping("/masterleagues/by-queue")
	public Mono<Object> masterLeaguesByQueue(@RequestHeader Map<String, String> headers,
			@RequestParam("queue") String queue) throws ApplicationHandler {
		return this.iLeagueService.masterLeaguesByQueue(headers, queue);
	}
}