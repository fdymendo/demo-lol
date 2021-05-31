package com.fdymendo.demolol.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdymendo.demolol.handler.ApplicationHandler;
import com.fdymendo.demolol.service.IChampionsService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/champion/v1/champion/rotations")
public class ChampionController {

	private final IChampionsService iChampionsService;

	@GetMapping
	public Mono<Object> getRotations(@RequestHeader Map<String, String> headers) throws ApplicationHandler {
		return iChampionsService.rotations(headers);
	}

}