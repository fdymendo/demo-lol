package com.fdymendo.demolol.util;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.fdymendo.demolol.handler.ApplicationHandler;

import lombok.Data;

@Data
@Configuration
public class AppVariables {
	
	@Value("${demo-lol.lol.apikey}")
	private String token;
	@Value("${demo-lol.la1.url}")
	private String la1UrlServer;
	
	@Value("${demo-lol.lol.path.summoner.by-account}")
	private String pathSummonerByAccount;
	@Value("${demo-lol.lol.path.summoner.by-name}")
	private String pathSummonerByName;
	@Value("${demo-lol.lol.path.summoner.by-puuid}")
	private String pathSummonerByPuuid;
	@Value("${demo-lol.lol.path.rotations}")
	private String pathRotations;

	@Value("${demo-lol.lol.path.spectator.active-games.by-summoner}")
	private String pathSpectatorActiveGamesBySummoner;
	@Value("${demo-lol.lol.path.spectator.featured-games}")
	private String pathSpectatorFeatureGames;
	
	public String generateUrlServerRiot(Map<String, String> headers) throws ApplicationHandler {
		String urlServerRiot = "";
		switch (headers.getOrDefault(AppConstants.HTTP_HEADER_SERVER_RIOT,"")) {
		case RiotConstants.RIOT_SERVER_LAN:
			urlServerRiot = la1UrlServer;
			break;

		default:
			throw new ApplicationHandler(AppConstants.ERROR_SERVER_RIOT);
		}
		return urlServerRiot;
	}
	
}