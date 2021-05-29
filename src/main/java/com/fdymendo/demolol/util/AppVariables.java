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
	//summoner
	@Value("${demo-lol.lol.path.summoner.by-account}")
	private String pathSummonerByAccount;
	@Value("${demo-lol.lol.path.summoner.by-name}")
	private String pathSummonerByName;
	@Value("${demo-lol.lol.path.summoner.by-puuid}")
	private String pathSummonerByPuuid;
	@Value("${demo-lol.lol.path.rotations}")
	private String pathRotations;
	//spectator
	@Value("${demo-lol.lol.path.spectator.active-games.by-summoner}")
	private String pathSpectatorActiveGamesBySummoner;
	@Value("${demo-lol.lol.path.spectator.featured-games}")
	private String pathSpectatorFeatureGames;
	//status
	@Value("${demo-lol.lol.path.status}")
	private String pathStatus;
	//league
	@Value("${demo-lol.lol.path.league.challenger-leagues.queue}")
	private String pathLeagueChallengerQueue;
	@Value("${demo-lol.lol.path.league.entries.entries}")
	private String pathLeagueEntries;
	@Value("${demo-lol.lol.path.league.entries.by-summoner}")
	private String pathLeagueEntriesBySummoner;
	@Value("${demo-lol.lol.path.league.grand-master-leagues.by-queue}")
	private String pathLeagueGrandMasterByQueue;
	@Value("${demo-lol.lol.path.league.leagues}")
	private String pathLeagueLeagues;
	@Value("${demo-lol.lol.path.league.master-leagues.by-queue}")
	private String pathLeagueMasterLeaguesByQueue;
	
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