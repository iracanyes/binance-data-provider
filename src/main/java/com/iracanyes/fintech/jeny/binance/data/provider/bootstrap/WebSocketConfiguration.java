package com.iracanyes.fintech.jeny.binance.data.provider.bootstrap;

import com.iracanyes.fintech.jeny.binance.data.provider.utils.BinanceConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.socket.client.ReactorNetty2WebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebSocketConfiguration {
  private WebSocketClient[] activeSocket;


  public WebSocketConfiguration(){
    activeSocket = new WebSocketClient[5];
  }
  //@Bean(name = "BinanceWebSocketClient")
  public WebSocketClient getWebSocketClient(){
    if(activeSocket.length == 0) {
      return new ReactorNetty2WebSocketClient();
    }else
      return activeSocket[activeSocket.length - 1];
  }

  //@Bean(name = "BinanceSpotTestnetWebsocketClient")
  public HttpClient.WebsocketSender getSpotTestnetWebSocketClient(){
    HttpClient.WebsocketSender websocketSender = HttpClient.create().websocket().uri(BinanceConstants.spotTestnetWebsocketApiUrl);
    return websocketSender;
  }

  //@Bean(name = "BinanceSpotApiTestnetWebSocketClient")
  public WebSocketClient getSpotApiTestnetWebSocketClient(){
    return new ReactorNetty2WebSocketClient();
  }
}
