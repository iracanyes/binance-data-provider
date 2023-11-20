package com.iracanyes.fintech.jeny.binance.data.provider.utils;

public final class BinanceConstants {
  private BinanceConstants(){

  }

  /**
   * Spot market API URL (limitations)
   */
  public static final String spotApiUrl = "https://api.binance.com/api";

  /**
   * Websocket API URL
   */
  public static final String spotWebsocketApiUrl = "wss://ws-api.binance.com/ws-api/v3";

  /**
   * Spot market Websocket URL
   */
  public static final String spotWebsocketUrl = "wss://stream.binance.com:9443/ws";

  /**
   * Spot market Websocket stream URL
   */
  public static final String spotWebsocketStreamUrl = "wss://stream.binance.com:9443/stream";

  /**
   * Spot Testnet network API URL ( limitations)
   */
  public static final String spotTestnetApiUrl = "https://testnet.binance.vision/api";

  /**
   * Spot API Testnet network Websocket  URL
   */
  public static final String spotTestnetWebsocketApiUrl = "wss://testnet.binance.vision/ws-api/v3";

  /**
   * Spot Testnet network Websocket URL
   */
  public static final String spotTestnetWebsocketUrl = "wss://testnet.binance.vision/ws";

  /**
   * Spot Testnet network Websocket Stream URL
   */
  public static final String spotTestnetWebsocketStreamUrl = "wss://testnet.binance.vision/stream";

  /**
   * Database endpoint
   * Used to access non-secure endpoint
   * Allow to access the following routes:
   *
     GET /api/v3/aggTrades
     GET /api/v3/avgPrice
     GET /api/v3/depth
     GET /api/v3/exchangeInfo
     GET /api/v3/klines
     GET /api/v3/ping
     GET /api/v3/ticker
     GET /api/v3/ticker/24hr
     GET /api/v3/ticker/bookTicker
     GET /api/v3/ticker/price
     GET /api/v3/time
     GET /api/v3/trades
     GET /api/v3/uiKlines

   */
  public static final String dataEndpoint = "https://data.binance.com";

  /**
   * Market data endpoint - test connectivity (Weight IP: 1)
   * Test connectivity to the Rest API.
   *
   * @See https://binance-docs.github.io/apidocs/spot/en/#test-connectivity
   */
  public static final String testConnectivity = "/api/v3/ping";

  /**
   * Market data endpoint - check server time (Weight IP: 1)
   * Test connectivity to the Rest API and get the current server time.
   *
   * @See https://binance-docs.github.io/apidocs/spot/en/#check-server-time
   */
  public static final String checkServerTime = "/api/v3/time";


  /**
   * Market data endpoint - Exchange information (Weight IP: 10)
   * 2 optional parameters:
   * - symbols:
   *  - single : curl -X GET "https://api.binance.com/api/v3/exchangeInfo?symbol=BNBBTC"
   *  - multiple : curl -g -X GET 'https://api.binance.com/api/v3/exchangeInfo?symbols=["BTCUSDT","BNBBTC"]'
   * - permissions:
   *  - single :  curl -X GET "https://api.binance.com/api/v3/exchangeInfo?permissions=SPOT"
   *  - multiple : curl -g -X GET 'https://api.binance.com/api/v3/exchangeInfo?permissions=["MARGIN","LEVERAGED"]'
   *
   * If permissions parameter not provided, the default values will be ["SPOT","MARGIN","LEVERAGED"].
   *
   * If one wants to view all symbols on GET /api/v3/exchangeInfo, then one has to search with all permissions explicitly specified
   * (i.e. permissions=["SPOT","MARGIN","LEVERAGED","TRD_GRP_002","TRD_GRP_003","TRD_GRP_004","TRD_GRP_005","TRD_GRP_006","TRD_GRP_007"])
   *
   * @See https://binance-docs.github.io/apidocs/spot/en/#exchange-information
   */
  public static final String exchangeInfo = "/api/v3/exchangeInfo";

  /**
   * Market data endpoint - Order book
   *
   *
   * @See https://binance-docs.github.io/apidocs/spot/en/#order-book
   */
   public static final String orderBook = "/api/v3/depth";

  /**
   * Market data endpoint - Recent Trades List (Weight IP: 1)
   * Get recent trades.
   * Parameters :
   *  - symbol (required),
   *  - limit (default: 500, max: 1000)
   * Doc : https://binance-docs.github.io/apidocs/spot/en/#recent-trades-list
   */
  public static final String recentTradesList = "/api/v3/trades";

}
