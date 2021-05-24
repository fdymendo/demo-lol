package com.fdymendo.demolol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.blockhound.BlockHound;

@SpringBootApplication
public class DemoLolApplication {

	public static void main(String[] args) {
		BlockHound.install();
		SpringApplication.run(DemoLolApplication.class, args);
	}

}
