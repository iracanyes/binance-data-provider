/**
 *
 */
package com.iracanyes.fintech.jeny.binance.data.provider.account;

import com.iracanyes.fintech.jeny.core.account.AccountDataProvider;
import com.iracanyes.fintech.jeny.core.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class BinanceAccountDataProvider implements AccountDataProvider<String>  {
  private Logger LOG = LoggerFactory.getLogger(BinanceAccountDataProvider.class);

  private WebClient spotApiClient;

  public BinanceAccountDataProvider(WebClient spotApiClient){
    this.spotApiClient = spotApiClient;
  }

  @Override
  public Mono<Account<String>> getAccountInfo(String accountID) {
    // Retrieve Account

    //

    return null;
  }


  public Mono<Account<String>> getSpotAccountInfo(String accountID) {
    return null;
  }


  public Mono<Account<String>> getMarginAccountInfo(String accountID) {
    return null;
  }

  @Override
  public Flux<Account<String>> getAllAccountInfo() {

    return null;
  }
}
