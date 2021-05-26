package com.fdymendo.demolol.service;

import java.util.Map;

import com.fdymendo.demolol.handler.ApplicationHandler;

import reactor.core.publisher.Mono;

public interface IChampionsService {

	Mono<Object> rotations(Map<String, String> headers) throws ApplicationHandler;
	
}