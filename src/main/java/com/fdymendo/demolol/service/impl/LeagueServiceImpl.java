package com.fdymendo.demolol.service.impl;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdymendo.demolol.dto.LeagueEntryDTO;
import com.fdymendo.demolol.dto.LeagueListDTO;
import com.fdymendo.demolol.handler.ApplicationHandler;
import com.fdymendo.demolol.service.ILeagueService;
import com.fdymendo.demolol.util.AppConstants;
import com.fdymendo.demolol.util.AppVariables;
import com.fdymendo.demolol.util.RiotConstants;
import com.fdymendo.demolol.util.UtilMethods;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
@Service
@RequiredArgsConstructor
public class LeagueServiceImpl implements ILeagueService {

	private final AppVariables appVariables;
	private final WebClient webClient;
	private final UtilMethods utilMethods;
	private final ObjectMapper objectMapper;

	@Override
	public Mono<Object> challengerLeaguesByQueue(Map<String, String> headers, String queue) throws ApplicationHandler {
		if (!utilMethods.validateQueue(queue)) {
			return Mono.error(
					new ResponseStatusException(HttpStatus.BAD_REQUEST, RiotConstants.RIOT_MESSAGE_ERROR_NO_QUEUE));
		}
		return webClient.mutate().baseUrl(this.utilMethods.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathLeagueChallengerQueue()).build(queue))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(LeagueListDTO.class);
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});
	}

	@Override
	public Mono<Object> entriesBySummoner(Map<String, String> headers, String encryptedSummonerId)
			throws ApplicationHandler {
		return webClient.mutate().baseUrl(this.utilMethods.generateUrlServerRiot(headers)).build().get().uri(
				uriBuilder -> uriBuilder.path(appVariables.getPathLeagueEntriesBySummoner()).build(encryptedSummonerId))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(String.class).map(n -> {
							try {
								@SuppressWarnings("unchecked")
								Set<LeagueEntryDTO> leagueEntryDTOs = objectMapper.readValue(n, Set.class);
								return leagueEntryDTOs;
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
	public Mono<Object> entries(Map<String, String> headers, String queue, String tier, String division, int page)
			throws ApplicationHandler {
		String message = validateRequestEntries(queue, tier, division);
		if (Objects.nonNull(message)) {
			return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, message));
		}
		Map<String, String> params = Map.of(RiotConstants.RIOT_LEAGUE_ENTRIES_QUEUE, queue,
				RiotConstants.RIOT_LEAGUE_ENTRIES_TIER, tier, RiotConstants.RIOT_LEAGUE_ENTRIES_DIVISION, division);
		return webClient.mutate().baseUrl(this.utilMethods.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathLeagueEntries())
						.queryParam(RiotConstants.RIOT_LEAGUE_ENTRIES_PAGE, page).build(params))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(String.class).map(n -> {
							try {
								@SuppressWarnings("unchecked")
								Set<LeagueEntryDTO> leagueEntryDTOs = objectMapper.readValue(n, Set.class);
								return leagueEntryDTOs;
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
	public Mono<Object> grandmasterLeaguesByQueue(Map<String, String> headers, String queue) throws ApplicationHandler {
		if (!this.utilMethods.validateQueue(queue)) {
			return Mono.error(
					new ResponseStatusException(HttpStatus.BAD_REQUEST, RiotConstants.RIOT_MESSAGE_ERROR_NO_QUEUE));
		}
		return webClient.mutate().baseUrl(this.utilMethods.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathLeagueGrandMasterByQueue()).build(queue))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(LeagueListDTO.class);
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});
	}

	@Override
	public Mono<Object> leagues(Map<String, String> headers, String leagueId) throws ApplicationHandler {
		return webClient.mutate().baseUrl(this.utilMethods.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathLeagueLeagues()).build(leagueId))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(LeagueListDTO.class);
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});
	}

	@Override
	public Mono<Object> masterLeaguesByQueue(Map<String, String> headers, String queue) throws ApplicationHandler {
		if (!this.utilMethods.validateQueue(queue)) {
			return Mono.error(
					new ResponseStatusException(HttpStatus.BAD_REQUEST, RiotConstants.RIOT_MESSAGE_ERROR_NO_QUEUE));
		}
		return webClient.mutate().baseUrl(this.utilMethods.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathLeagueMasterLeaguesByQueue()).build(queue))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(LeagueListDTO.class);
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});
	}

	private String validateRequestEntries(String queue, String tier, String division) {
		if (!this.utilMethods.validateQueue(queue))
			return RiotConstants.RIOT_MESSAGE_ERROR_NO_QUEUE;
		if (!this.utilMethods.validateTier(tier))
			return RiotConstants.RIOT_MESSAGE_ERROR_NO_TIER;
		if (!this.utilMethods.validateDivision(division))
			return RiotConstants.RIOT_MESSAGE_ERROR_NO_DIVISION;
		return null;
	}

}