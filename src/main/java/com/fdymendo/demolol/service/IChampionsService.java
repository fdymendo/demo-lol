package com.fdymendo.demolol.service;

import reactor.core.publisher.Mono;

public interface IChampionsService {

	Mono<Object> rotations();
}