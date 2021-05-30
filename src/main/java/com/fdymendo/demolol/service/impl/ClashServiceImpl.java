package com.fdymendo.demolol.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdymendo.demolol.dto.PlayerDto;
import com.fdymendo.demolol.dto.TeamDto;
import com.fdymendo.demolol.dto.TournamentDto;
import com.fdymendo.demolol.handler.ApplicationHandler;
import com.fdymendo.demolol.service.IClashService;
import com.fdymendo.demolol.util.AppConstants;
import com.fdymendo.demolol.util.AppVariables;
import com.fdymendo.demolol.util.UtilMethods;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class ClashServiceImpl implements IClashService {

	private final AppVariables appVariables;
	private final WebClient webClient;
	private final UtilMethods utilMethods;
	private final ObjectMapper objectMapper;

	public ClashServiceImpl(AppVariables appVariables, WebClient webClient, UtilMethods utilMethods,
			ObjectMapper objectMapper) {
		this.appVariables = appVariables;
		this.webClient = webClient;
		this.utilMethods = utilMethods;
		this.objectMapper = objectMapper;

	}

	@Override
	public Mono<Object> playersBySummoner(Map<String, String> headers, String summonerId) throws ApplicationHandler {
		return webClient.mutate().baseUrl(this.utilMethods.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathClashPlayersBySummoner()).build(summonerId))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(String.class).map(n -> {
							try {
								@SuppressWarnings("unchecked")
								List<PlayerDto> listPlayerDtos = objectMapper.readValue(n, List.class);
								return listPlayerDtos;
							} catch (JsonMappingException e) {
								log.error(AppConstants.APP_ERROR_MESSAGE_JSON_MAPPING_EXCEPTION, e);
								return Mono.empty();
							} catch (JsonProcessingException e) {
								log.error(AppConstants.APP_ERROR_MESSAGE_JSON_PROCESSING_EXCEPTION, e);
								return Mono.empty();
							}
						});
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});
	}

	@Override
	public Mono<Object> teams(Map<String, String> headers, String teamId) throws ApplicationHandler {
		return webClient.mutate().baseUrl(this.utilMethods.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathClashTeams()).build(teamId))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(TeamDto.class);
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});
	}

	@Override
	public Mono<Object> tournaments(Map<String, String> headers) throws ApplicationHandler {
		return webClient.mutate().baseUrl(this.utilMethods.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathClashTournamentsTournaments()).build())
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(String.class).map(n -> {
							try {
								@SuppressWarnings("unchecked")
								List<TournamentDto> listTournamentDtos = objectMapper.readValue(n, List.class);
								return listTournamentDtos;
							} catch (JsonMappingException e) {
								log.error(AppConstants.APP_ERROR_MESSAGE_JSON_MAPPING_EXCEPTION, e);
								return Mono.empty();
							} catch (JsonProcessingException e) {
								log.error(AppConstants.APP_ERROR_MESSAGE_JSON_PROCESSING_EXCEPTION, e);
								return Mono.empty();
							}
						});
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});
	}

	@Override
	public Mono<Object> tournamentsByTeam(Map<String, String> headers, String teamId) throws ApplicationHandler {
		return webClient.mutate().baseUrl(this.utilMethods.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathClashTournamentsByTeam()).build(teamId))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(TournamentDto.class);
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});
	}

	@Override
	public Mono<Object> tournamentsByTournamentId(Map<String, String> headers, String tournamentId)
			throws ApplicationHandler {
		return webClient.mutate().baseUrl(this.utilMethods.generateUrlServerRiot(headers)).build().get().uri(
				uriBuilder -> uriBuilder.path(appVariables.getPathClashTournamentsTournamentId()).build(tournamentId))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(TournamentDto.class);
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});
	}

}