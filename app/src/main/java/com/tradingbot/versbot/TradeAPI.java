//package com.tradingbot.smatestbot2;
//
//import android.util.Log;
//
//import org.json.JSONObject;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Locale;
//import java.util.Map;
//
//public class TradeAPI extends BaseAPI {
//
//    private static final String TAG = "TradeAPI";
//
//    public TradeAPI(String baseUrl, String token) {
//        super(baseUrl, token);
//    }
//
//    public String getTrades(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/trades", "GET", null);
//    }
//
//    public String getOpenTrades(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/openTrades", "GET", null);
//    }
//
//    public String getTradeDetails(String accountId, String tradeSpecifier) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/trades/" + tradeSpecifier, "GET", null);
//    }
//
//    public String closeTrade(String accountId, String tradeSpecifier) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/trades/" + tradeSpecifier + "/close", "PUT", null);
//    }
//
//    public String updateTradeClientExtensions(String accountId, String tradeSpecifier, Map<String, Object> clientExtensions) throws Exception {
//        JSONObject jsonBody = new JSONObject(clientExtensions);
//        return makeRequest("/v3/accounts/" + accountId + "/trades/" + tradeSpecifier + "/clientExtensions", "PUT", jsonBody.toString());
//    }
//
//    public String updateTradeOrders(String accountId, String tradeSpecifier, Map<String, Object> orderData) throws Exception {
//        JSONObject jsonBody = new JSONObject(orderData);
//        return makeRequest("/v3/accounts/" + accountId + "/trades/" + tradeSpecifier + "/orders", "PUT", jsonBody.toString());
//    }
//
//    private void log(String message) {
//        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
//        Log.d(TAG, timestamp + " - " + message);
//    }
//}


package com.tradingbot.versbot;

import android.content.Context;
import android.util.Log;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class TradeAPI extends BaseAPI {

    private static final String TAG = "TradeAPI";

    public TradeAPI(String baseUrl, String token, Context context) {
        super(baseUrl, token, context);
    }

    public String getTrades(String accountId) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/trades", "GET", null);
    }

    public String getOpenTrades(String accountId) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/openTrades", "GET", null);
    }

    public String getTradeDetails(String accountId, String tradeSpecifier) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/trades/" + tradeSpecifier, "GET", null);
    }

    public String closeTrade(String accountId, String tradeSpecifier) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/trades/" + tradeSpecifier + "/close", "PUT", null);
    }

    public String updateTradeClientExtensions(String accountId, String tradeSpecifier, Map<String, Object> clientExtensions) throws Exception {
        JSONObject jsonBody = new JSONObject(clientExtensions);
        return makeRequest("/v3/accounts/" + accountId + "/trades/" + tradeSpecifier + "/clientExtensions", "PUT", jsonBody.toString());
    }

    public String updateTradeOrders(String accountId, String tradeSpecifier, Map<String, Object> orderData) throws Exception {
        JSONObject jsonBody = new JSONObject(orderData);
        return makeRequest("/v3/accounts/" + accountId + "/trades/" + tradeSpecifier + "/orders", "PUT", jsonBody.toString());
    }

    private void log(String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
        Log.d(TAG, timestamp + " - " + message);
    }
}
