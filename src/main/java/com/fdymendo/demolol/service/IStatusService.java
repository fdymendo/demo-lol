package com.fdymendo.demolol.service;

import java.util.Map;

import com.fdymendo.demolol.handler.ApplicationHandler;

import reactor.core.publisher.Mono;

public interface IStatusService {

	Mono<Object> status(Map<String, String> headers) throws ApplicationHandler;

}