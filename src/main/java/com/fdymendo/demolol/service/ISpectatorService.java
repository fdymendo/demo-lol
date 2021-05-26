package com.fdymendo.demolol.service;

import java.util.Map;

import reactor.core.publisher.Mono;

public interface ISpectatorService {

	Mono<Object> activeGamesBySummoner(Map<String, String> headers, String encryptedSummonerId);
	Mono<Object> featuredGames(Map<String, String> headers);

}