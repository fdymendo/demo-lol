package com.fdymendo.demolol.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdymendo.demolol.dto.CurrentGameInfo;
import com.fdymendo.demolol.dto.FeaturedGames;
import com.fdymendo.demolol.handler.ApplicationHandler;
import com.fdymendo.demolol.service.ISpectatorService;
import com.fdymendo.demolol.util.AppVariables;
import com.fdymendo.demolol.util.UtilMethods;

import reactor.core.publisher.Mono;

@Service
public class SpectatorServiceImpl implements ISpectatorService {

	private final AppVariables appVariables;
	private final WebClient webClient;

	public SpectatorServiceImpl(AppVariables appVariables, WebClient webClient) {
		this.appVariables = appVariables;
		this.webClient = webClient;
	}

	@Override
	public Mono<Object> activeGamesBySummoner(Map<String, String> headers, String encryptedSummonerId)
			throws ApplicationHandler {
		return webClient.mutate().baseUrl(this.appVariables.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathSpectatorActiveGamesBySummoner())
						.build(encryptedSummonerId))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(CurrentGameInfo.class);
					} else {
						return UtilMethods.writeResposeApiRiotError(response);
					}
				});
	}

	@Override
	public Mono<Object> featuredGames(Map<String, String> headers) throws ApplicationHandler {
		return webClient.mutate().baseUrl(this.appVariables.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathSpectatorFeatureGames()).build())
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(FeaturedGames.class);
					} else {
						return UtilMethods.writeResposeApiRiotError(response);
					}
				});
	}

}