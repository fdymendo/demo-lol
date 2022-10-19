package com.fdymendo.demolol.service.impl;

import java.util.Map;

import javax.net.ssl.SSLException;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdymendo.demolol.dto.SummonerDTO;
import com.fdymendo.demolol.handler.ApplicationHandler;
import com.fdymendo.demolol.service.ISummonerService;
import com.fdymendo.demolol.util.AppVariables;
import com.fdymendo.demolol.util.UtilMethods;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SummonerServiceImpl implements ISummonerService {

	private final AppVariables appVariables;
	private final WebClient webClient;
	private final UtilMethods utilMethods;

	@Override
	public Mono<Object> encryptedAccountId(Map<String, String> headers, String encryptedAccountId)
			throws ApplicationHandler, SSLException {

		return webClient.mutate().baseUrl(this.utilMethods.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathSummonerByAccount()).build(encryptedAccountId))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(SummonerDTO.class);
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});
	}

	@Override
	public Mono<Object> summonerName(Map<String, String> headers, String summonerName) throws ApplicationHandler {
		return webClient.mutate().baseUrl(this.utilMethods.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathSummonerByName()).build(summonerName))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(SummonerDTO.class);
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});

	}

	@Override
	public Mono<Object> encryptedPUUID(Map<String, String> headers, String encryptedPUUID) throws ApplicationHandler {
		return webClient.mutate().baseUrl(this.utilMethods.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathSummonerByPuuid()).build(encryptedPUUID))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(SummonerDTO.class);
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});
	}

	@Override
	public Mono<Object> summoners(Map<String, String> headers, String encryptedSummonerId) throws ApplicationHandler {
		return webClient.mutate().baseUrl(this.utilMethods.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathSummonerSummoners()).build(encryptedSummonerId))
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(SummonerDTO.class);
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});
	}

}