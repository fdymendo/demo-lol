package com.fdymendo.demolol.controller;

import java.util.Map;

import javax.net.ssl.SSLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdymendo.demolol.handler.ApplicationHandler;
import com.fdymendo.demolol.service.ISummonerService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/summoner/v1/summoners/")
public class SummonerController {

	private final ISummonerService iSummonerService;

	@GetMapping(value = "by-account/{encryptedAccountId}")
	public Mono<Object> getByAccount(@RequestHeader Map<String, String> headers,
			@PathVariable("encryptedAccountId") String encryptedAccountId) throws ApplicationHandler, SSLException {
		return iSummonerService.encryptedAccountId(headers, encryptedAccountId);
	}

	@GetMapping(value = "by-name/{summonerName}")
	public Mono<Object> getByName(@RequestHeader Map<String, String> headers,
			@PathVariable("summonerName") String summonerName) throws ApplicationHandler {
		return iSummonerService.summonerName(headers, summonerName);
	}

	@GetMapping(value = "by-puuid/{encryptedPUUID}")
	public Mono<Object> getByPuuid(@RequestHeader Map<String, String> headers,
			@PathVariable("encryptedPUUID") String encryptedPUUID) throws ApplicationHandler {
		return iSummonerService.encryptedPUUID(headers, encryptedPUUID);
	}
	@GetMapping(value = "{encryptedSummonerId}")
	public Mono<Object> summoners(@RequestHeader Map<String, String> headers,
			@PathVariable("encryptedSummonerId") String pUUID) throws ApplicationHandler {
		return iSummonerService.summoners(headers, pUUID);
	}

}