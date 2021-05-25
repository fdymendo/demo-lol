package com.fdymendo.demolol.service;

import java.util.Map;

import javax.net.ssl.SSLException;

import com.fdymendo.demolol.handler.ErrorClass;

import reactor.core.publisher.Mono;

public interface ISummonerService {
	
	Mono<Object> encryptedAccountId(Map<String, String> headers, String accountId) throws ErrorClass, SSLException;
	Mono<Object> summonerName(Map<String, String> headers, String summonerName) throws ErrorClass;
	Mono<Object> encryptedPUUID(Map<String, String> headers, String pUUID) throws ErrorClass;

}