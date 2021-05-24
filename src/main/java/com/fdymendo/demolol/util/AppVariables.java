package com.fdymendo.demolol.util;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.fdymendo.demolol.handler.ErrorClass;

import lombok.Data;

@Data
@Configuration
public class AppVariables {

	@Value("${demo-lol.lol.la1.url}")
	private String la1UrlServer;
	@Value("${demo-lol.lol.summoner.by-account}")
	private String urlSummonerByAccount;
	@Value("${demo-lol.lol.summoner.by-name}")
	private String urlSummonerByName;
	@Value("${demo-lol.lol.summoner.by-puuid}")
	private String urlSummonerByPuuid;
	@Value("${demo-lol.lol.apikey}")
	private String token;
	@Value("${demo-lol.lol.rotations}")
	private String pathRotations;

	public String generateUrlServerRiot(Map<String, String> headers) throws ErrorClass {
		String urlServerRiot = "";
		switch (headers.getOrDefault(AppConstants.HTTP_HEADER_SERVER_RIOT,"")) {
		case RiotConstants.RIOT_SERVER_LAN:
			urlServerRiot = la1UrlServer;
			break;

		default:
			throw new ErrorClass(AppConstants.ERROR_SERVER_RIOT);
		}
		return urlServerRiot;
	}
}