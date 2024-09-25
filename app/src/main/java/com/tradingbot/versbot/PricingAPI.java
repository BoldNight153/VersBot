//package com.tradingbot.smatestbot2;
//
//import android.util.Log;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Locale;
//
//public class PricingAPI extends BaseAPI {
//
//    private static final String TAG = "PricingAPI";
//
//    public PricingAPI(String baseUrl, String token) {
//        super(baseUrl, token);
//    }
//
//    public String getPricing(String accountId) throws Exception {
//        log("Fetching pricing for account: " + accountId);
//        return makeRequest("/v3/accounts/" + accountId + "/pricing", "GET", null);
//    }
//
//    public String getPricingStream(String accountId) throws Exception {
//        log("Fetching pricing stream for account: " + accountId);
//        return makeRequest("/v3/accounts/" + accountId + "/pricing/stream", "GET", null);
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

public class PricingAPI extends BaseAPI {

    private static final String TAG = "PricingAPI";

    public PricingAPI(String baseUrl, String token, Context context) {
        super(baseUrl, token, context);
    }

    public String getPricing(String accountId) throws Exception {
        log("Fetching pricing for account: " + accountId);
        return makeRequest("/v3/accounts/" + accountId + "/pricing", "GET", null);
    }

    public String getPricingStream(String accountId) throws Exception {
        log("Fetching pricing stream for account: " + accountId);
        return makeRequest("/v3/accounts/" + accountId + "/pricing/stream", "GET", null);
    }

    private void log(String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
        Log.d(TAG, timestamp + " - " + message);
    }
}
