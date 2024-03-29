package com.fdymendo.demolol.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdymendo.demolol.dto.PlatformDataDto;
import com.fdymendo.demolol.handler.ApplicationHandler;
import com.fdymendo.demolol.service.IStatusService;
import com.fdymendo.demolol.util.AppVariables;
import com.fdymendo.demolol.util.UtilMethods;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements IStatusService {

	private final AppVariables appVariables;
	private final WebClient webClient;
	private final UtilMethods utilMethods;

	@Override
	public Mono<Object> status(Map<String, String> headers) throws ApplicationHandler {
		return webClient.mutate().baseUrl(this.utilMethods.generateUrlServerRiot(headers)).build().get()
				.uri(uriBuilder -> uriBuilder.path(appVariables.getPathStatus()).build()).exchangeToMono(response -> {
					if (response.statusCode().is2xxSuccessful()) {
						return response.bodyToMono(PlatformDataDto.class);
					} else {
						return utilMethods.writeResposeApiRiotError(response);
					}
				});
	}

}