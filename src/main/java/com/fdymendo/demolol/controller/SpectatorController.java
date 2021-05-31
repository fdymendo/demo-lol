package com.fdymendo.demolol.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdymendo.demolol.handler.ApplicationHandler;
import com.fdymendo.demolol.service.ISpectatorService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/spectator/v1/spectator/")
public class SpectatorController {
	
	private final ISpectatorService iSpectatorService;

	@GetMapping("/active-games/by-summoner/{encryptedSummonerId}")
	public Mono<Object> getActiveGameBySummoner(@RequestHeader Map<String, String> headers,
			@PathVariable("encryptedSummonerId") String encryptedSummonerId) throws ApplicationHandler {
		return iSpectatorService.activeGamesBySummoner(headers, encryptedSummonerId);
	}

	@GetMapping("/featured-games")
	public Mono<Object> featuredGames(@RequestHeader Map<String, String> headers) throws ApplicationHandler {
		return iSpectatorService.featuredGames(headers);
	}

}