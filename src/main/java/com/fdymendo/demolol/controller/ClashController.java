package com.fdymendo.demolol.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fdymendo.demolol.handler.ApplicationHandler;
import com.fdymendo.demolol.service.IClashService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clash/v1/lol/clash/v1")
public class ClashController {

	private final IClashService iClashService;

	public ClashController(IClashService iClashService) {
		this.iClashService = iClashService;
	}

	@GetMapping("/players/by-summoner")
	public Mono<Object> playersBySummoner(@RequestHeader Map<String, String> headers,
			@RequestParam("summonerId") String summonerId) throws ApplicationHandler {
		return iClashService.playersBySummoner(headers, summonerId);
	}

	@GetMapping("/teams")
	public Mono<Object> teamsTeamId(@RequestHeader Map<String, String> headers, @RequestParam("teamId") String teamId)
			throws ApplicationHandler {
		return iClashService.teams(headers, teamId);
	}

	@GetMapping("/tournaments")
	public Mono<Object> tournaments(@RequestHeader Map<String, String> headers) throws ApplicationHandler {
		return iClashService.tournaments(headers);
	}

	@GetMapping("/tournaments/by-team")
	public Mono<Object> tournamentsByTeam(@RequestHeader Map<String, String> headers,
			@RequestParam("teamId") String teamId) throws ApplicationHandler {
		return iClashService.tournamentsByTeam(headers, teamId);
	}

	@GetMapping("/tournaments/tournamentId")
	public Mono<Object> tournamentsTournamentsId(@RequestHeader Map<String, String> headers,
			@RequestParam("tournamentId") String tournamentId) throws ApplicationHandler {
		return iClashService.tournamentsByTournamentId(headers, tournamentId);
	}

}