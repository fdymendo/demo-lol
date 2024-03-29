package com.fdymendo.demolol.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdymendo.demolol.handler.ApplicationHandler;
import com.fdymendo.demolol.service.IStatusService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/status/v1/status/")
public class StatusController {

	private final IStatusService iStatusService;

	@GetMapping("platform-data")
	public Mono<Object> getStatus(@RequestHeader Map<String, String> headers) throws ApplicationHandler {
		return iStatusService.status(headers);
	}

}