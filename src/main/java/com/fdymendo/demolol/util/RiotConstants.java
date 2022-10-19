package com.fdymendo.demolol.util;

public class RiotConstants {

	public static final String RIOT_SERVER_LAN = "LA1";
	public static final String RIOT_REQUESTED_RESOURCE = "con el recurso solicitado";
	public static final String RIOT_400 = "El servidor realizo una peticion incorrecta ".concat(RIOT_REQUESTED_RESOURCE)
			.concat(", ").concat(AppConstants.APP_SUPPORT);
	public static final String RIOT_401 = "El servidor no esta autenticado ".concat(RIOT_REQUESTED_RESOURCE)
			.concat(", ").concat(AppConstants.APP_SUPPORT);
	public static final String RIOT_403 = "El servidor no tiene acceso ".concat(RIOT_REQUESTED_RESOURCE).concat(", ")
			.concat(AppConstants.APP_SUPPORT);
	public static final String RIOT_404 = "El servidor no pudo encontrar el contenido ".concat(RIOT_REQUESTED_RESOURCE)
			.concat(", ").concat(AppConstants.APP_SUPPORT);
	public static final String RIOT_405 = "El servidor no tiene el metodo permitido ".concat(RIOT_REQUESTED_RESOURCE)
			.concat(", ").concat(AppConstants.APP_SUPPORT);
	public static final String RIOT_415 = "El servidor envio el formato multimedia incorrecto "
			.concat(RIOT_REQUESTED_RESOURCE).concat(", ").concat(AppConstants.APP_SUPPORT);
	public static final String RIOT_429 = "El servidor ha enviado demasiadas peticiones "
			.concat(RIOT_REQUESTED_RESOURCE).concat(", ").concat(AppConstants.APP_SUPPORT);
	public static final String RIOT_500 = "El servidor recibio una respuesta de error intentero "
			.concat(RIOT_REQUESTED_RESOURCE).concat(", ").concat(AppConstants.APP_SUPPORT);
	public static final String RIOT_502 = "El servidor recibio como respuesta un error en conexion externa "
			.concat(RIOT_REQUESTED_RESOURCE).concat(", ").concat(AppConstants.APP_SUPPORT);
	public static final String RIOT_503 = "El servidor recibio como respuesta un estado de espera "
			.concat(RIOT_REQUESTED_RESOURCE).concat(", ").concat(AppConstants.APP_SUPPORT);
	public static final String RIOT_504 = "El servidor recibio como respuesta timeout ".concat(RIOT_REQUESTED_RESOURCE)
			.concat(", ").concat(AppConstants.APP_SUPPORT);
	// Message Error
	public static final String RIOT_MESSAGE_ERROR_NO_MESSAGE = "No se encontro un mensaje adecuado para responder";
	public static final String RIOT_MESSAGE_ERROR_NO_QUEUE = "No se encontro una cola adecuada";
	public static final String RIOT_MESSAGE_ERROR_NO_DIVISION ="No se encontro una division adecuada";
	public static final String RIOT_MESSAGE_ERROR_NO_TIER = "No se encontro un tier adecuado";

	
	// entries
	public static final String RIOT_LEAGUE_ENTRIES_QUEUE = "queue";
	public static final String RIOT_LEAGUE_ENTRIES_TIER = "tier";
	public static final String RIOT_LEAGUE_ENTRIES_DIVISION = "division";
	public static final String RIOT_LEAGUE_ENTRIES_PAGE = "page";
	public static final String RIOT_LEAGUE_ENTRIES_SUMMONER_ID = "encryptedSummonerId";
	public static final String RIOT_LEAGUE_ENTRIES_CHAMPION_ID = "championId";
	// Queue
	public static final String RIOT_RANKED_SOLO_5X5 = "RANKED_SOLO_5x5";
	public static final String RIOT_RANKED_FLEX_SR = "RANKED_FLEX_SR";
	public static final String RIOT_RANKED_FLEX_TT = "RANKED_FLEX_TT";
	// tier
	public static final String RIOT_TIER_DIAMOND = "DIAMOND";
	public static final String RIOT_TIER_PLATINUM = "PLATINUM";
	public static final String RIOT_TIER_GOLD = "GOLD";
	public static final String RIOT_TIER_SILVER = "SILVER";
	public static final String RIOT_TIER_BRONZE = "BRONZE";
	public static final String RIOT_TIER_IRON = "IRON";
	// Division
	public static final String RIOT_DIVION_1 = "I";
	public static final String RIOT_DIVION_2 = "II";
	public static final String RIOT_DIVION_3 = "III";
	public static final String RIOT_DIVION_4 = "IV";

}