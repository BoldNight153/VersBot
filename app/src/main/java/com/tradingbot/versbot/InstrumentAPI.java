//package com.tradingbot.smatestbot2;
//
//// InstrumentAPI class
//public class InstrumentAPI extends BaseAPI {
//
//    public InstrumentAPI(String baseUrl, String token) {
//        super(baseUrl, token);
//    }
//
//    public String getCandles(String instrument) throws Exception {
//        return makeRequest("/v3/instruments/" + instrument + "/candles", "GET", null);
//    }
//
//    public String getOrderBook(String instrument) throws Exception {
//        return makeRequest("/v3/instruments/" + instrument + "/orderBook", "GET", null);
//    }
//
//    public String getPositionBook(String instrument) throws Exception {
//        return makeRequest("/v3/instruments/" + instrument + "/positionBook", "GET", null);
//    }
//}

//package com.tradingbot.smatestbot2;
//
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class InstrumentAPI extends BaseAPI {
//
//    public InstrumentAPI(String baseUrl, String token) {
//        super(baseUrl, token);
//    }
//
//    public String getCandles(String instrument, String granularity, int count) throws Exception {
//        String endpoint = "/v3/instruments/" + instrument + "/candles?granularity=" + granularity + "&count=" + count;
//        return makeRequest(endpoint, "GET", null);
//    }
//
//    public String getOrderBook(String instrument) throws Exception {
//        return makeRequest("/v3/instruments/" + instrument + "/orderBook", "GET", null);
//    }
//
//    public String getPositionBook(String instrument) throws Exception {
//        return makeRequest("/v3/instruments/" + instrument + "/positionBook", "GET", null);
//    }
//}

//package com.tradingbot.smatestbot2;
//
//import android.util.Log;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Locale;
//
//public class InstrumentAPI extends BaseAPI {
//
//    private static final String TAG = "InstrumentAPI";
//
//    public InstrumentAPI(String baseUrl, String token) {
//        super(baseUrl, token);
//    }
//
//    public String getCandles(String instrument, String granularity, int count) throws Exception {
//        log("Fetching candles for instrument: " + instrument + ", granularity: " + granularity + ", count: " + count);
//        return makeRequest("/v3/instruments/" + instrument + "/candles?granularity=" + granularity + "&count=" + count, "GET", null);
//    }
//
//    public String getOrderBook(String instrument) throws Exception {
//        return makeRequest("/v3/instruments/" + instrument + "/orderBook", "GET", null);
//    }
//
//    public String getPositionBook(String instrument) throws Exception {
//        return makeRequest("/v3/instruments/" + instrument + "/positionBook", "GET", null);
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class InstrumentAPI extends BaseAPI {

    private static final String TAG = "InstrumentAPI";

    public InstrumentAPI(String baseUrl, String token, Context context) {
        super(baseUrl, token, context);
    }

    public String getCandles(String instrument, String granularity, int count) throws Exception {
        log("Fetching candles for instrument: " + instrument + ", granularity: " + granularity + ", count: " + count);
        return makeRequest("/v3/instruments/" + instrument + "/candles?granularity=" + granularity + "&count=" + count, "GET", null);
    }

    public String getOrderBook(String instrument) throws Exception {
        return makeRequest("/v3/instruments/" + instrument + "/orderBook", "GET", null);
    }

    public String getPositionBook(String instrument) throws Exception {
        return makeRequest("/v3/instruments/" + instrument + "/positionBook", "GET", null);
    }

    private void log(String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
        Log.d(TAG, timestamp + " - " + message);
    }
}
