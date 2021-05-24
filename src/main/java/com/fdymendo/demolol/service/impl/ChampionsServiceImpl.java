package com.fdymendo.demolol.service.impl;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse.Headers;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdymendo.demolol.model.RotationsResponse;
import com.fdymendo.demolol.service.IChampionsService;
import com.fdymendo.demolol.util.AppConstants;
import com.fdymendo.demolol.util.AppVariables;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
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

		Mono<Object> respuesta = webClient.get().headers(headers -> {
			headers.add(AppConstants.HTTP_HEADER_R_ACCEPT_CHARSET, AppConstants.HTTP_HEADER_R_ACCEPT_CHARSET_V);
			headers.add(AppConstants.HTTP_HEADER_TOKEN, this.appVariables.getToken());

		}).exchangeToMono(response -> {
			Headers headers = response.headers();
			HttpHeaders httpHeaders = headers.asHttpHeaders();
			Map<String, String> headersMap = httpHeaders.toSingleValueMap();
			log.info("Map: {}", headersMap);

			if (response.statusCode().is2xxSuccessful()) {
				log.info("se respondio un 200 {}", response);
				return response.bodyToMono(RotationsResponse.class);
			} else if (response.statusCode().is4xxClientError()) {
				log.error("se respondio un 400 {}", response);
				return response.bodyToMono(RotationsResponse.class);
			} else {
				log.error("se respondio un error {}", response);
				Exception e = new Exception();
				return Mono.error(e);
			}
		});
		return respuesta;
	}

}