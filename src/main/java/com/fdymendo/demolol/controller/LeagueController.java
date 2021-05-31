package com.fdymendo.demolol.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fdymendo.demolol.handler.ApplicationHandler;
import com.fdymendo.demolol.service.ILeagueService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/league/v1/league/")
public class LeagueController {

	private final ILeagueService iLeagueService;

	@GetMapping("challengerleagues/by-queue/{queue}")
	public Mono<Object> challengerLeagueByQueue(@RequestHeader Map<String, String> headers,
			@PathVariable("queue") String queue) throws ApplicationHandler {
		return this.iLeagueService.challengerLeaguesByQueue(headers, queue);
	}

	@GetMapping("entries/by-summoner/{encryptedSummonerId}")
	public Mono<Object> entriesBySummoner(@RequestHeader Map<String, String> headers,
			@PathVariable("encryptedSummonerId") String encryptedSummonerId) throws ApplicationHandler {
		return this.iLeagueService.entriesBySummoner(headers, encryptedSummonerId);
	}

	@GetMapping("entries/{queue}/{tier}/{division}")
	public Mono<Object> entries(@RequestHeader Map<String, String> headers, @PathVariable("queue") String queue,
			@PathVariable("tier") String tier, @PathVariable("division") String division,
			@RequestParam("page") int page) throws ApplicationHandler {
		return this.iLeagueService.entries(headers, queue, tier, division, page);
	}

	@GetMapping("grandmasterleagues/by-queue/{queue}")
	public Mono<Object> grandMasterByQueue(@RequestHeader Map<String, String> headers,
			@PathVariable("queue") String queue) throws ApplicationHandler {
		return this.iLeagueService.grandmasterLeaguesByQueue(headers, queue);
	}

	@GetMapping("leagues/{leagueId}")
	public Mono<Object> leagues(@RequestHeader Map<String, String> headers, @PathVariable("leagueId") String leagueId)
			throws ApplicationHandler {
		return this.iLeagueService.leagues(headers, leagueId);
	}

	@GetMapping("masterleagues/by-queue/{queue}")
	public Mono<Object> masterLeaguesByQueue(@RequestHeader Map<String, String> headers,
			@PathVariable("queue") String queue) throws ApplicationHandler {
		return this.iLeagueService.masterLeaguesByQueue(headers, queue);
	}
}