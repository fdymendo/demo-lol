package com.fdymendo.demolol.util;

import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdymendo.demolol.handler.ApplicationHandler;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
@Configuration
public class UtilMethods {

	private final ObjectMapper objectMapper;
	private final AppVariables appVariables;

	public UtilMethods(AppVariables appVariables, ObjectMapper objectMapper) {
		this.appVariables = appVariables;
		this.objectMapper = objectMapper;
	}

	public String generateUrlServerRiot(Map<String, String> headers) throws ApplicationHandler {
		String urlServerRiot = "";
		switch (headers.getOrDefault(AppConstants.HTTP_HEADER_SERVER_RIOT, "")) {
		case RiotConstants.RIOT_SERVER_LAN:
			urlServerRiot = appVariables.getLa1UrlServer();
			break;

		default:
			throw new ApplicationHandler(AppConstants.ERROR_SERVER_RIOT);
		}
		return urlServerRiot;
	}

	public Mono<Object> writeResposeApiRiotError(ClientResponse clientResponse) {
		try {
			log.info("Status code response: {}", clientResponse.statusCode().value());
			log.info("Object response: {}",
					objectMapper.writeValueAsString(clientResponse.bodyToFlux(Object.class).cast(Object.class)));
		} catch (JsonProcessingException e) {
			log.error("error processing message info");
		}
		HttpStatus httpStatus = generateHttpStatusPredefinedRiot(clientResponse);
		String message = generateMessagePredefinedRiot(clientResponse);
		return Mono.error(new ResponseStatusException(httpStatus, message));
	}

	private HttpStatus generateHttpStatusPredefinedRiot(ClientResponse clientResponse) {
		HttpStatus httpStatus = HttpStatus.valueOf(clientResponse.statusCode().value());
		return httpStatus;
	}

	private String generateMessagePredefinedRiot(ClientResponse clientResponse) {
		String message = "";
		switch (clientResponse.statusCode().value()) {
		case 400:
			message = RiotConstants.RIOT_400;
			break;
		case 401:
			message = RiotConstants.RIOT_401;
			break;
		case 403:
			message = RiotConstants.RIOT_403;
			break;
		case 404:
			message = RiotConstants.RIOT_404;
			break;
		case 405:
			message = RiotConstants.RIOT_405;
			break;
		case 415:
			message = RiotConstants.RIOT_415;
			break;
		case 429:
			message = RiotConstants.RIOT_429;
			break;
		case 500:
			message = RiotConstants.RIOT_500;
			break;
		case 502:
			message = RiotConstants.RIOT_502;
			break;
		case 503:
			message = RiotConstants.RIOT_503;
			break;
		case 504:
			message = RiotConstants.RIOT_504;
			break;
		default:
			log.error("code error: {}", clientResponse.statusCode().value());
			try {
				log.error("Object response: {}",
						objectMapper.writeValueAsString(clientResponse.bodyToFlux(Object.class).cast(Object.class)));
			} catch (JsonProcessingException e) {
				log.error(AppConstants.APP_ERROR_MESSAGE_JSON_PROCESSING_EXCEPTION, e);
			}
			message = RiotConstants.RIOT_MESSAGE_ERROR_NO_MESSAGE;
			break;
		}
		return message;
	}

	public boolean validateQueue(String queue) {
		Map<String, String> validQueue = Map.of(RiotConstants.RIOT_RANKED_SOLO_5X5, "",
				RiotConstants.RIOT_RANKED_FLEX_SR, "", RiotConstants.RIOT_RANKED_FLEX_TT, "");
		return validQueue.containsKey(queue);
	}

	public boolean validateDivision(String division) {
		Map<String, String> validDivision = Map.of(RiotConstants.RIOT_DIVION_1, "", RiotConstants.RIOT_DIVION_2, "",
				RiotConstants.RIOT_DIVION_3, "", RiotConstants.RIOT_DIVION_4, "");
		return validDivision.containsKey(division);
	}

	public boolean validateTier(String tier) {
		Map<String, String> validTier = Map.of(RiotConstants.RIOT_TIER_DIAMOND, "", RiotConstants.RIOT_TIER_PLATINUM,
				"", RiotConstants.RIOT_TIER_GOLD, "", RiotConstants.RIOT_TIER_BRONZE, "", RiotConstants.RIOT_TIER_IRON,
				"");
		return validTier.containsKey(tier);
	}

}