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

}