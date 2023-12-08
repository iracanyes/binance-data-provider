package com.iracanyes.fintech.jeny.binance.data.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;
//import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;


@SpringBootApplication
@EnableWebFlux
//@EnableMongoRepositories
// Only for ORM database as mysql, jdbc
//@EnableR2dbcRepositories
@EnableReactiveMongoRepositories
public class BinanceDataProviderApplication {
	private final Logger LOGGER = LoggerFactory.getLogger(BinanceDataProviderApplication.class.getName());

	public BinanceDataProviderApplication(){
		// TODO document why this constructor is empty
	}


	public static void main(String[] args) {

		SpringApplication.run(BinanceDataProviderApplication.class, args);

	}


}
