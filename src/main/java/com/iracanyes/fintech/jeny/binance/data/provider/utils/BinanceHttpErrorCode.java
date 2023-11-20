package com.iracanyes.fintech.jeny.binance.data.provider.utils;

public enum BinanceHttpErrorCode {
  // 10XX General server or Network issue
  E1000(1000, "Unknown error occured while processing the request"),
  E1001(1001, "Disconnected! Internal error, unable to process your request. Please try again."),
  E1002(1002, "Unauthorized! You aren't authorized to execute this request."),
  E1003(1003, "Too many requests (in the queue or request weight limit reached or banned"),
  E1004(1004, "Server busy, please wait and try again"),
  E1006(1006, "Unexpected response received from the message bus. Execution status unkown."),
  E1007(1007, "Timeout waiting for response from backend server. Send status unknown; execution status unknown."),
  E1008(1008, "Spot server is currently overloaded with other requests. Please try again in a few minutes. "),
  E1014(1014, "Unknown order composition. Unsupported order combination."),
  E1015(1015, "Too many new orders"),
  E1016(1016, "Service shutting down. This service is no longer available."),
  E1020(1020, "Unsupported operation. This operation is not supported."),
  E1021(1021, "Invalid timestamp for this request. (not in range or timestamp ahead of server time"),
  E1022(1022, "Invalid signature. Signature for this request is not valid. "),
  E1099(1099, "Not found or authenticated or authorized"),
  // 11XX to 2XXX - Request issues
  E1100(1100, "ILLEGAL_CHARS : Illegal characters found in a parameter."),
  E1101(1101, "TOO_MANY_PARAMETERS : Too many parameters sent ( for this endpoint, than expected or duplicate values ) "),
  E1102(1102, "MANDATORY_PARAM_EMPTY_OR_MALFORMED"),
  E1103(1103, "UNKNOWN_PARAM : An unknown parameter was sent."),
  E1104(1104, "UNREAD_PARAMETERS : Not all sent parameters were read."),
  E1105(1105, "PARAM_EMPTY : A parameter was empty."),
  E1106(1106, "PARAM_NOT_REQUIRED : A parameter was sent when not required."),
  E1111(1111, "BAD_PRECISION : Precision is over the maximum defined for this asset."),
  E1112(1112, "NO_DEPTH : No orders on book for symbol."),
  E1114(1014, "TIF_NOT_REQUIRED : TimeInForce parameter sent when not required."),
  E1115(1115, "INVALID_TIF : Invalid timeInForce."),
  E1116(1116, "INVALID_ORDER_TYPE : Invalid orderType."),
  E1117(1117, "INVALID_SIDE : Invalid side."),
  E1118(1118, "EMPTY_NEW_CL_ORD_ID : New client order ID was empty."),
  E1119(1119, "EMPTY_ORG_CL_ORD_ID : Original client order ID was empty."),
  E1120(1120, "BAD_INTERVAL: Invalid interval."),
  E1121(1121, "BAD_SYMBOL : Invalid symbol."),
  E1125(1125, " INVALID_LISTEN_KEY : This listenKey does not exist."),
  E1127(1127, "MORE_THAN_XX_HOURS : Lookup interval is too big."),
  E1128(1128, "OPTIONAL_PARAMS_BAD_COMBO : Combination of optional parameters invalid."),
  E1130(1130, "INVALID_REQUEST_PARAMETER : Invalid data sent for a parameter."),
  E1131(1131, "BAD_RECV_WINDOW : recvWindow must be less than 60000."),
  E1134(1134, "BAD_STRATEGY_TYPE : strategyType was less than 1000000. "),
  E2010(2010, "NEW_ORDER_REJECTED"),
  E2011(2011, "CANCEL_REJECTED"),
  E2013(2013, "NO_SUCH_ORDER : Order does not exist."),
  E2014(2014, "BAD_API_KEY_FMT : API-key format invalid."),
  E2015(2015, "REJECTED_MBX_KEY : Invalid API-key, IP, or permissions for action."),
  E2016(2016, "NO_TRADING_WINDOW : No trading window could be found for the symbol. Try ticker/24hrs instead.");


  private final int errorCode;
  public final String message;
  private BinanceHttpErrorCode(int pErrorCode, String pMessage){
    this.errorCode = pErrorCode;
    this.message = pMessage;
  }

  public int getErrorCode(){
    return errorCode;
  }
  public String getMessage(){
    return message;
  }
}
