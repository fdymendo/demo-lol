package com.fdymendo.demolol.util;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.handler.ssl.ApplicationProtocolNames;
import io.netty.handler.ssl.SslContextBuilder;
import nl.altindag.ssl.SSLFactory;
import nl.altindag.ssl.util.NettySslUtils;
import reactor.netty.http.HttpProtocol;
import reactor.netty.http.client.HttpClient;

@Configuration
public class Config {
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
	public SSLFactory getInternalSslFactory() {
		return SSLFactory.builder().withDefaultTrustMaterial().build();
	}

	@Bean
	public SslContextBuilder getSslContextBuilder(SSLFactory sslFactory) {
		final ApplicationProtocolConfig applicationProtocolConfig = new ApplicationProtocolConfig(
				ApplicationProtocolConfig.Protocol.ALPN, ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE,
				ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT, ApplicationProtocolNames.HTTP_2,
				ApplicationProtocolNames.HTTP_1_1);
		return NettySslUtils.forClient(sslFactory).applicationProtocolConfig(applicationProtocolConfig);
	}

	@Bean
	public HttpClient getHttpClient(SslContextBuilder sslContextBuilder) {
		return HttpClient.create().wiretap(false).metrics(true, Function.identity()).protocol(HttpProtocol.HTTP11)
				.secure(sslContextSpec -> sslContextSpec.sslContext(sslContextBuilder));
	}
}