//package com.tradingbot.smatestbot2;
//
//import android.util.Log;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Locale;
//
//public class PositionAPI extends BaseAPI {
//
//    private static final String TAG = "PositionAPI";
//
//    public PositionAPI(String baseUrl, String token) {
//        super(baseUrl, token);
//    }
//
//    public String getPositions(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/positions", "GET", null);
//    }
//
//    public String getOpenPositions(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/openPositions", "GET", null);
//    }
//
//    public String getPositionDetails(String accountId, String instrument) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/positions/" + instrument, "GET", null);
//    }
//
//    public String closePosition(String accountId, String instrument) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/positions/" + instrument + "/close", "PUT", null);
//    }
//
//    private void log(String message) {
//        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
//        Log.d(TAG, timestamp + " - " + message);
//    }
//}
//


package com.tradingbot.versbot;

import android.content.Context;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PositionAPI extends BaseAPI {

    private static final String TAG = "PositionAPI";

    public PositionAPI(String baseUrl, String token, Context context) {
        super(baseUrl, token, context);
    }

    public String getPositions(String accountId) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/positions", "GET", null);
    }

    public String getOpenPositions(String accountId) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/openPositions", "GET", null);
    }

    public String getPositionDetails(String accountId, String instrument) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/positions/" + instrument, "GET", null);
    }

    public String closePosition(String accountId, String instrument) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/positions/" + instrument + "/close", "PUT", null);
    }

    private void log(String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
        Log.d(TAG, timestamp + " - " + message);
    }
}
