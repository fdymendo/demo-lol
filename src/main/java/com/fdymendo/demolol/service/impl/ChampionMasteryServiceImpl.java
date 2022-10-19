package com.fdymendo.demolol.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdymendo.demolol.dto.ChampionMasteryDto;
import com.fdymendo.demolol.handler.ApplicationHandler;
import com.fdymendo.demolol.service.IChampionMasteryService;
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
public class ChampionMasteryServiceImpl implements IChampionMasteryService {

	private final WebClient webClient;
	private final UtilMethods utilMethods;
	private final AppVariables appVariables;
	private final ObjectMapper objectMapper;

	@Override
	public Mono<Object> bySummoner(Map<String, String> headers, String encryptedSummonerId) throws ApplicationHandler {
		return webClient.mutate().baseUrl(this.utilMethods.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathChampionMasteryBySummonerEncriptedSummonerId())
						.build(encryptedSummonerId))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(String.class).map(n -> {
							try {
								@SuppressWarnings("unchecked")
								List<ChampionMasteryDto> leagueEntryDTOs = objectMapper.readValue(n, List.class);
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
	public Mono<Object> bySummonerByChampion(Map<String, String> headers, String summonerId, String championId)
			throws ApplicationHandler {
		Map<String, String> params = Map.of(RiotConstants.RIOT_LEAGUE_ENTRIES_SUMMONER_ID, summonerId,
				RiotConstants.RIOT_LEAGUE_ENTRIES_CHAMPION_ID, championId);
		return webClient.mutate().baseUrl(this.utilMethods.generateUrlServerRiot(headers)).build().get().uri(
				uriBuilder -> uriBuilder.path(appVariables.getPathChampionMasteryBySummoneByChampion()).build(params))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(ChampionMasteryDto.class);
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});
	}

	@Override
	public Mono<Object> scoreBySummoner(Map<String, String> headers, String summonerId) throws ApplicationHandler {
		return webClient.mutate().baseUrl(this.utilMethods.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathChampionMasteryScoreBySummoner())
						.build(summonerId))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(int.class);
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});
	}

}