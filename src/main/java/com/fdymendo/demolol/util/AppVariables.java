package com.fdymendo.demolol.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class AppVariables {

	@Value("${demo-lol.lol.apikey}")
	private String token;
	@Value("${demo-lol.la1.url}")
	private String la1UrlServer;
	// summoner
	@Value("${demo-lol.lol.path.summoner.by-account}")
	private String pathSummonerByAccount;
	@Value("${demo-lol.lol.path.summoner.by-name}")
	private String pathSummonerByName;
	@Value("${demo-lol.lol.path.summoner.by-puuid}")
	private String pathSummonerByPuuid;
	@Value("${demo-lol.lol.path.summoner.summoners}")
	private String pathSummonerSummoners;
	//champion
	@Value("${demo-lol.lol.path.rotations}")
	private String pathRotations;
	// spectator
	@Value("${demo-lol.lol.path.spectator.active-games.by-summoner}")
	private String pathSpectatorActiveGamesBySummoner;
	@Value("${demo-lol.lol.path.spectator.featured-games}")
	private String pathSpectatorFeatureGames;
	// status
	@Value("${demo-lol.lol.path.status}")
	private String pathStatus;
	// league
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
	// clash
	@Value("${demo-lol.lol.path.clash.players.by-summoner}")
	private String pathClashPlayersBySummoner;
	@Value("${demo-lol.lol.path.clash.teams}")
	private String pathClashTeams;
	@Value("${demo-lol.lol.path.clash.tournaments.tournaments}")
	private String pathClashTournamentsTournaments;
	@Value("${demo-lol.lol.path.clash.tournaments.by-team}")
	private String pathClashTournamentsByTeam;
	@Value("${demo-lol.lol.path.clash.tournaments.tournament-id}")
	private String pathClashTournamentsTournamentId;
	//champion-mistery
	@Value("${demo-lol.lol.path.champion-mastery.by-summoner.encripted-summoner-id}")
	private String pathChampionMasteryBySummonerEncriptedSummonerId;
	@Value("${demo-lol.lol.path.champion-mastery.by-summoner.by-champion}")
	private String pathChampionMasteryBySummoneByChampion;
	@Value("${demo-lol.lol.path.champion-mastery.scores.by-summoner}")
	private String pathChampionMasteryScoreBySummoner;
	
}