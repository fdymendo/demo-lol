package com.fdymendo.demolol.service.impl;

import java.util.Map;

import javax.net.ssl.SSLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdymendo.demolol.handler.ErrorClass;
import com.fdymendo.demolol.model.SummonerResponse;
import com.fdymendo.demolol.service.ISummonerService;
import com.fdymendo.demolol.util.AppConstants;
import com.fdymendo.demolol.util.AppVariables;
import com.fdymendo.demolol.util.UtilMethods;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.netty.http.client.HttpClient;

@Service
public class SummonerServiceImpl implements ISummonerService {

	private final AppVariables appVariables;

	@Autowired
	WebClient webClient;

	public SummonerServiceImpl(AppVariables appVariables) {
		this.appVariables = appVariables;
	}

	@Override
	public Mono<Object> encryptedAccountId(Map<String, String> headers, String accountId)
			throws ErrorClass, SSLException {
		
		return webClient.mutate().baseUrl(this.appVariables.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getUrlSummonerByAccount()).build(accountId))
				.headers(headersClient -> {
					headersClient.add(AppConstants.HTTP_HEADER_R_ACCEPT_CHARSET,
							AppConstants.HTTP_HEADER_R_ACCEPT_CHARSET_V);
					headersClient.add(AppConstants.HTTP_HEADER_TOKEN, this.appVariables.getToken());
				}).exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(SummonerResponse.class);
					} else {
						return UtilMethods.writeResposeApiRiotError(response);
					}
				}).subscribeOn(Schedulers.boundedElastic());
	}

	@Override
	public Mono<Object> summonerName(Map<String, String> headers, String summonerName) throws ErrorClass {
		WebClient webClient = WebClient.create(this.appVariables.generateUrlServerRiot(headers)).mutate()
				.clientConnector(new ReactorClientHttpConnector(HttpClient.create().compress(true).secure())).build();

		return webClient.mutate().baseUrl(this.appVariables.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getUrlSummonerByName()).build(summonerName))
				.headers(headersClient -> {
					headersClient.add(AppConstants.HTTP_HEADER_R_ACCEPT_CHARSET,
							AppConstants.HTTP_HEADER_R_ACCEPT_CHARSET_V);
					headersClient.add(AppConstants.HTTP_HEADER_TOKEN, this.appVariables.getToken());
				}).exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(SummonerResponse.class);
					} else {
						return UtilMethods.writeResposeApiRiotError(response);
					}
				});

	}

	@Override
	public Mono<Object> encryptedPUUID(Map<String, String> headers, String pUUID) throws ErrorClass {
		WebClient webClient = WebClient.create(this.appVariables.generateUrlServerRiot(headers));
		return webClient.get().uri(uriBuilder -> uriBuilder.path(appVariables.getUrlSummonerByPuuid()).build(pUUID))
				.headers(headersClient -> {
					headersClient.add(AppConstants.HTTP_HEADER_R_ACCEPT_CHARSET,
							AppConstants.HTTP_HEADER_R_ACCEPT_CHARSET_V);
					headersClient.add(AppConstants.HTTP_HEADER_TOKEN, this.appVariables.getToken());
				}).exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(SummonerResponse.class);
					} else {
						return UtilMethods.writeResposeApiRiotError(response);
					}
				});
	}

}