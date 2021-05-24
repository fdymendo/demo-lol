package com.fdymendo.demolol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdymendo.demolol.service.IChampionsService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/champion/rotations")
public class champion {

	@Autowired
	private IChampionsService iChampionsService;

	@GetMapping
	public Mono<Object> getRotations() {
		return iChampionsService.rotations();
	}
}