package com.fdymendo.demolol.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
public class UtilMethods {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static Mono<Object> writeResposeApiRiotError(ClientResponse clientResponse) {
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

	private static HttpStatus generateHttpStatusPredefinedRiot(ClientResponse clientResponse) {
		HttpStatus httpStatus = HttpStatus.valueOf(clientResponse.statusCode().value());
		return httpStatus;
	}

	private static String generateMessagePredefinedRiot(ClientResponse clientResponse) {
		String message = "";
		switch (clientResponse.statusCode().value()) {
		case 403:
			message = RiotConstants.RIOT_403;
			break;
		default:
			message = "no se encontro mensaje";
			break;
		}
		return message;
	}
	
}