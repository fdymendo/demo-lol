package com.fdymendo.demolol.service.impl;

import java.util.Map;

import com.fdymendo.demolol.service.ISpectatorService;

import reactor.core.publisher.Mono;

public class SpectatorServiceImpl implements ISpectatorService{

	@Override
	public Mono<Object> activeGamesBySummoner(Map<String, String> headers, String encryptedSummonerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Object> featuredGames(Map<String, String> headers) {
		// TODO Auto-generated method stub
		return null;
	}

}