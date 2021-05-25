package com.fdymendo.demolol.service.impl;

import java.util.Map;
import org.springframework.stereotype.Service;
import com.fdymendo.demolol.service.IAccountService;
import reactor.core.publisher.Mono;

/**
 * @author jeisson
 *
 */
@Service
public class AccountServiceImpl implements IAccountService {

	@Override
	public Mono<Object> getByPuuid(Map<String, String> headers, String puuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Object> getByRiotId(Map<String, String> headers, String riotId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Object> getAccount(Map<String, String> headers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Object> getActiveShards(Map<String, String> headers, String game, String riotId) {
		// TODO Auto-generated method stub
		return null;
	}

}
