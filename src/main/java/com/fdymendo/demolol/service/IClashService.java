package com.fdymendo.demolol.service;

import java.util.Map;

import com.fdymendo.demolol.handler.ApplicationHandler;

import reactor.core.publisher.Mono;

public interface IClashService {

	Mono<Object> playersBySummoner(Map<String, String> headers, String summonerId) throws ApplicationHandler;

	Mono<Object> teams(Map<String, String> headers, String teamId) throws ApplicationHandler;

	Mono<Object> tournaments(Map<String, String> headers) throws ApplicationHandler;

	Mono<Object> tournamentsByTeam(Map<String, String> headers, String teamId) throws ApplicationHandler;

	Mono<Object> tournamentsByTournamentId(Map<String, String> headers, String tournamentId) throws ApplicationHandler;

}