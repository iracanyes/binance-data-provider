package com.iracanyes.fintech.jeny.binance.data.provider.bootstrap;

import com.iracanyes.fintech.jeny.binance.data.provider.utils.BinanceConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BinanceApiConnectionConfiguration {
  /**
   * The following base endpoints are available:
   *
   *     https://api.binance.com
   *     https://api1.binance.com
   *     https://api2.binance.com
   *     https://api3.binance.com
   *     https://api4.binance.com
   * @return
   */
  @Bean(name = "spotApiClient")
  public WebClient getSpotApiClient(){
    return WebClient.create(BinanceConstants.spotApiUrl);
  }

  @Bean(name = "testnetSpotApiClient")
  public WebClient getTestnetSpotApiClient(){
    return WebClient.create(BinanceConstants.spotTestnetApiUrl);
  }

  /**
   * The base endpoint https://data.binance.com can be used to access the following API endpoints that have NONE as security type:
   *
   *     GET /api/v3/aggTrades
   *     GET /api/v3/avgPrice
   *     GET /api/v3/depth
   *     GET /api/v3/exchangeInfo
   *     GET /api/v3/klines
   *     GET /api/v3/ping
   *     GET /api/v3/ticker
   *     GET /api/v3/ticker/24hr
   *     GET /api/v3/ticker/bookTicker
   *     GET /api/v3/ticker/price
   *     GET /api/v3/time
   *     GET /api/v3/trades
   *     GET /api/v3/uiKlines
   * @return Client to Binance Data API
   */
  @Bean(name = "dataApiClient")
  public WebClient getDataApiClient(){
    return WebClient.create(BinanceConstants.dataEndpoint);
  }
}
