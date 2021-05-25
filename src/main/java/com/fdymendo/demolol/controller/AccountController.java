package com.fdymendo.demolol.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fdymendo.demolol.service.IAccountService;
import com.fdymendo.demolol.service.impl.AccountServiceImpl;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/account/v1/accounts")
public class AccountController {

	@Autowired
	private IAccountService accountService;
	
	public AccountController(AccountServiceImpl accountServiceImpl) {
		this.accountService = accountServiceImpl;		
	}
	@GetMapping(value = "by-puuid")
	public Mono<Object> getByPuuid(@RequestHeader Map<String, String> headers, @RequestParam("puuid") String puuid) {
		return accountService.getByPuuid(headers, puuid);
	}
	@GetMapping(value = "by-riot-id")
	public Mono<Object> getByRiotId(@RequestHeader Map<String, String> headers, @RequestParam("riotId") String riotId) {
		return accountService.getByRiotId(headers, riotId);
	}
	@GetMapping(value = "me")
	public Mono<Object> getAccount(@RequestHeader Map<String, String> headers) {
		return accountService.getAccount(headers);
	}
	@GetMapping(value = "by-game")
	public Mono<Object> getActiveShards(@RequestHeader Map<String, String> headers, 
			@RequestParam("game") String game,@RequestParam("riotId")  String riotId) {
		return accountService.getActiveShards(headers, game, riotId);
	}
}
