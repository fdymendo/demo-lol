package com.fdymendo.demolol.service;

import java.util.Map;

import com.fdymendo.demolol.handler.ApplicationHandler;

import reactor.core.publisher.Mono;

public interface IChampionMasteryService {
	
	Mono<Object> bySummoner(Map<String, String> headers, String encryptedSummonerId) throws ApplicationHandler;
	Mono<Object> bySummonerByChampion(Map<String, String> headers, String summonerId, String championId) throws ApplicationHandler;
	Mono<Object> scoreBySummoner(Map<String, String> headers, String summonerId) throws ApplicationHandler;

}