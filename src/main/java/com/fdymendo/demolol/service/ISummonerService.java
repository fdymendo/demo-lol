package com.fdymendo.demolol.service;

import java.util.Map;

import javax.net.ssl.SSLException;

import com.fdymendo.demolol.handler.ApplicationHandler;

import reactor.core.publisher.Mono;

public interface ISummonerService {
	
	Mono<Object> encryptedAccountId(Map<String, String> headers, String encryptedAccountId) throws ApplicationHandler, SSLException;
	Mono<Object> summonerName(Map<String, String> headers, String summonerName) throws ApplicationHandler;
	Mono<Object> encryptedPUUID(Map<String, String> headers, String encryptedPUUID) throws ApplicationHandler;
	Mono<Object> summoners(Map<String, String> headers, String encryptedSummonerId) throws ApplicationHandler;

}