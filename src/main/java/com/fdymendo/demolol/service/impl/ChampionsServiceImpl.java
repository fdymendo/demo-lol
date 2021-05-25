package com.fdymendo.demolol.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdymendo.demolol.model.RotationsResponse;
import com.fdymendo.demolol.service.IChampionsService;
import com.fdymendo.demolol.util.AppConstants;
import com.fdymendo.demolol.util.AppVariables;
import com.fdymendo.demolol.util.UtilMethods;

import reactor.core.publisher.Mono;

@Service
public class ChampionsServiceImpl implements IChampionsService {

	private final AppVariables appVariables;

	public ChampionsServiceImpl(AppVariables appVariables) {
		this.appVariables = appVariables;
	}

	@Override
	public Mono<Object> rotations() {

		WebClient webClient = WebClient
				.create(this.appVariables.getLa1UrlServer().concat(this.appVariables.getPathRotations()));

		return webClient.get().headers(headers -> {
			headers.add(AppConstants.HTTP_HEADER_R_ACCEPT_CHARSET, AppConstants.HTTP_HEADER_R_ACCEPT_CHARSET_V);
			headers.add(AppConstants.HTTP_HEADER_TOKEN, this.appVariables.getToken());
		}).exchangeToMono(response -> {
			if (response.statusCode().is2xxSuccessful()) {
				return response.bodyToMono(RotationsResponse.class);
			} else {
				return UtilMethods.writeResposeApiRiotError(response);
			}
		});
	}

}