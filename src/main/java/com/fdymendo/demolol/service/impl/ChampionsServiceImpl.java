package com.fdymendo.demolol.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdymendo.demolol.dto.RotationsResponse;
import com.fdymendo.demolol.handler.ApplicationHandler;
import com.fdymendo.demolol.service.IChampionsService;
import com.fdymendo.demolol.util.AppVariables;
import com.fdymendo.demolol.util.UtilMethods;

import reactor.core.publisher.Mono;

@Service
public class ChampionsServiceImpl implements IChampionsService {

	private final AppVariables appVariables;
	private final WebClient webClient;
	private final UtilMethods utilMethods;

	public ChampionsServiceImpl(AppVariables appVariables, WebClient webClient,UtilMethods utilMethods) {
		this.appVariables = appVariables;
		this.webClient = webClient;
		this.utilMethods = utilMethods;
		
	}

	@Override
	public Mono<Object> rotations(Map<String, String> headers) throws ApplicationHandler {

		return webClient.mutate().baseUrl(this.appVariables.generateUrlServerRiot(headers)).build().get()
				.exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(RotationsResponse.class);
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});
	}

}