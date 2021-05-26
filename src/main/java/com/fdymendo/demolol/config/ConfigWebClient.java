package com.fdymendo.demolol.config;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.netty.http.Http2SslContextSpec;
import reactor.netty.http.HttpProtocol;
import reactor.netty.http.client.HttpClient;

@Configuration
public class ConfigWebClient {
	
	@Bean
	@Primary
	public ClientHttpConnector getClientHttpConnector(HttpClient httpClient) {
		return new ReactorClientHttpConnector(httpClient);
	}

	@Bean
	@Primary
	public WebClient getWebClient(ClientHttpConnector clientHttpConnector) {
		return WebClient.builder()
				.clientConnector(new ReactorClientHttpConnector(HttpClient.create().compress(true).secure())).build();

	}

	@Bean
	public Http2SslContextSpec getHttp2SslContextSpec() {
		return Http2SslContextSpec.forClient();
	}

	@Bean
	public HttpClient getHttpClient(Http2SslContextSpec http2SslContextSpec) {
		return HttpClient.create().wiretap(false).metrics(true, Function.identity()).protocol(HttpProtocol.HTTP11)
				.secure(sslContextSpec -> sslContextSpec.sslContext(http2SslContextSpec));
	}
	
}