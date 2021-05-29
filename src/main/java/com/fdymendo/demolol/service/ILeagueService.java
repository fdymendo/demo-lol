package com.fdymendo.demolol.service;

import java.util.Map;

import com.fdymendo.demolol.handler.ApplicationHandler;

import reactor.core.publisher.Mono;

public interface ILeagueService {

	Mono<Object> challengerLeaguesByQueue(Map<String, String> headers, String queue) throws ApplicationHandler;

	Mono<Object> entriesBySummoner(Map<String, String> headers, String encryptedSummonerId) throws ApplicationHandler;

	Mono<Object> entries(Map<String, String> headers, String queue, String tier, String division, int page) throws ApplicationHandler;

	Mono<Object> grandmasterLeaguesByQueue(Map<String, String> headers, String queue) throws ApplicationHandler;

	Mono<Object> leagues(Map<String, String> headers, String leagueId) throws ApplicationHandler;

	Mono<Object> masterLeaguesByQueue(Map<String, String> headers, String queue) throws ApplicationHandler;

}