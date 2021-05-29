package com.fdymendo.demolol.service.impl;

import java.util.Map;

import javax.net.ssl.SSLException;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdymendo.demolol.dto.SummonerResponse;
import com.fdymendo.demolol.handler.ApplicationHandler;
import com.fdymendo.demolol.service.ISummonerService;
import com.fdymendo.demolol.util.AppVariables;
import com.fdymendo.demolol.util.UtilMethods;

import reactor.core.publisher.Mono;

@Service
public class SummonerServiceImpl implements ISummonerService {

	private final AppVariables appVariables;
	private final WebClient webClient;
	private final UtilMethods utilMethods;

	public SummonerServiceImpl(AppVariables appVariables, WebClient webClient, UtilMethods utilMethods) {
		this.appVariables = appVariables;
		this.webClient = webClient;
		this.utilMethods = utilMethods;
	}

	@Override
	public Mono<Object> encryptedAccountId(Map<String, String> headers, String accountId)
			throws ApplicationHandler, SSLException {

		return webClient.mutate().baseUrl(this.appVariables.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathSummonerByAccount()).build(accountId))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(SummonerResponse.class);
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});
	}

	@Override
	public Mono<Object> summonerName(Map<String, String> headers, String summonerName) throws ApplicationHandler {
		return webClient.mutate().baseUrl(this.appVariables.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathSummonerByName()).build(summonerName))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(SummonerResponse.class);
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});

	}

	@Override
	public Mono<Object> encryptedPUUID(Map<String, String> headers, String pUUID) throws ApplicationHandler {
		return webClient.mutate().baseUrl(this.appVariables.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathSummonerByPuuid()).build(pUUID))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(SummonerResponse.class);
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});
	}

}