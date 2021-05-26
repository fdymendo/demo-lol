package com.fdymendo.demolol.service;

import java.util.Map;

import com.fdymendo.demolol.handler.ApplicationHandler;

import reactor.core.publisher.Mono;

public interface ISpectatorService {

	Mono<Object> activeGamesBySummoner(Map<String, String> headers, String encryptedSummonerId) throws ApplicationHandler;
	Mono<Object> featuredGames(Map<String, String> headers) throws ApplicationHandler;

}