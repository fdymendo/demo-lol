package com.fdymendo.demolol.service;

import java.util.Map;

/**
 * @author jeisson
 *
 */
import reactor.core.publisher.Mono;

public interface IAccountService {
	
	Mono<Object> getByPuuid(Map<String, String> headers, String puuid);
	Mono<Object> getByRiotId(Map<String, String> headers, String riotId);
	Mono<Object> getAccount(Map<String, String> headers);
	Mono<Object> getActiveShards(Map<String, String> headers, String game, String riotId);
}
