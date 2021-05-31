package com.fdymendo.demolol.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdymendo.demolol.handler.ApplicationHandler;
import com.fdymendo.demolol.service.IClashService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clash/v1/clash/")
public class ClashController {

	private final IClashService iClashService;

	@GetMapping("players/by-summoner/{summonerId}")
	public Mono<Object> playersBySummoner(@RequestHeader Map<String, String> headers,
			@PathVariable("summonerId") String summonerId) throws ApplicationHandler {
		return iClashService.playersBySummoner(headers, summonerId);
	}

	@GetMapping("teams/{teamId}")
	public Mono<Object> teamsTeamId(@RequestHeader Map<String, String> headers, @PathVariable("teamId") String teamId)
			throws ApplicationHandler {
		return iClashService.teams(headers, teamId);
	}

	@GetMapping("tournaments")
	public Mono<Object> tournaments(@RequestHeader Map<String, String> headers) throws ApplicationHandler {
		return iClashService.tournaments(headers);
	}

	@GetMapping("tournaments/by-team/{teamId}")
	public Mono<Object> tournamentsByTeam(@RequestHeader Map<String, String> headers,
			@PathVariable("teamId") String teamId) throws ApplicationHandler {
		return iClashService.tournamentsByTeam(headers, teamId);
	}

	@GetMapping("tournaments/{tournamentId}")
	public Mono<Object> tournamentsTournamentsId(@RequestHeader Map<String, String> headers,
			@PathVariable("tournamentId") String tournamentId) throws ApplicationHandler {
		return iClashService.tournamentsByTournamentId(headers, tournamentId);
	}

}