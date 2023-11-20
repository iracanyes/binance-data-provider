package com.iracanyes.fintech.jeny.binance.data.provider.bootstrap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.socket.client.ReactorNetty2WebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;

@Configuration
public class BinanceWebSocketConfiguration {
  private WebSocketClient[] activeSocket;

  private BinanceWebSocketConfiguration(){
    activeSocket = new WebSocketClient[5];
  }
  @Bean(name = "BinanceWebSocketClient")
  public WebSocketClient getWebSocketClient(){
    if(activeSocket.length == 0)
      return new ReactorNetty2WebSocketClient();
    else
      return activeSocket[activeSocket.length - 1];
  }

  @Bean(name = "BinanceSpotTestnetWebsocketClient")
  public WebSocketClient getSpotTestnetWebSocketClient(){
    return new ReactorNetty2WebSocketClient();
  }

  @Bean(name = "BinanceSpotApiTestnetWebSocketClient")
  public WebSocketClient getSpotApiTestnetWebSocketClient(){
    return new ReactorNetty2WebSocketClient();
  }
}
