package com.fdymendo.demolol.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdymendo.demolol.dto.RotationsResponse;
import com.fdymendo.demolol.handler.ApplicationHandler;
import com.fdymendo.demolol.service.IChampionsService;
import com.fdymendo.demolol.util.AppConstants;
import com.fdymendo.demolol.util.AppVariables;
import com.fdymendo.demolol.util.UtilMethods;

import reactor.core.publisher.Mono;

@Service
public class ChampionsServiceImpl implements IChampionsService {

	private final AppVariables appVariables;
	private final WebClient webClient;
	
	public ChampionsServiceImpl(AppVariables appVariables, WebClient webClient) {
		this.appVariables = appVariables;
		this.webClient = webClient;
	}

	@Override
	public Mono<Object> rotations(Map<String, String> headers) throws ApplicationHandler {

		return webClient.mutate().baseUrl(this.appVariables.generateUrlServerRiot(headers)).build().get().headers(headersClient -> {
			headersClient.add(AppConstants.HTTP_HEADER_R_ACCEPT_CHARSET, AppConstants.HTTP_HEADER_R_ACCEPT_CHARSET_V);
			headersClient.add(AppConstants.HTTP_HEADER_TOKEN, this.appVariables.getToken());
		}).exchangeToMono(response -> {
			if (response.statusCode().is2xxSuccessful()) {
				return response.bodyToMono(RotationsResponse.class);
			} else {
				return UtilMethods.writeResposeApiRiotError(response);
			}
		});
	}

}