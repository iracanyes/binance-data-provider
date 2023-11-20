package com.iracanyes.fintech.jeny.binance.data.provider.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;


@SpringBootApplication
//@EnableR2dbcRepositories
public class BinanceDataProviderApplication {
	private final Logger logger = LoggerFactory.getLogger(BinanceDataProviderApplication.class.getName());

	public BinanceDataProviderApplication(){
	}

	public static void main(String[] args) {

		SpringApplication.run(BinanceDataProviderApplication.class, args);

		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(VaultConfiguration.class);
		//context.start();

	}


}
