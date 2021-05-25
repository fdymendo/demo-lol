package com.fdymendo.demolol.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fdymendo.demolol.handler.ErrorClass;
import com.fdymendo.demolol.service.ISummonerService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/summoner/v4/summoners")
public class SummonerController {

	@Autowired
	private ISummonerService iSummonerService;

	@GetMapping(value = "by-account")
	public Mono<Object> getByAccount(@RequestHeader Map<String, String> headers,
			@RequestParam("accountId") String accountId) throws ErrorClass {
		return iSummonerService.encryptedAccountId(headers, accountId);
	}

	@GetMapping(value = "by-name")
	public Mono<Object> getByName(@RequestHeader Map<String, String> headers,
			@RequestParam("summonerName") String summonerName) throws ErrorClass {
		return iSummonerService.summonerName(headers, summonerName);
	}

	@GetMapping(value = "by-puuid")
	public Mono<Object> getByPuuid(@RequestHeader Map<String, String> headers,
			@RequestParam("puuid") String pUUID) throws ErrorClass {
		return iSummonerService.encryptedPUUID(headers, pUUID);
	}

}