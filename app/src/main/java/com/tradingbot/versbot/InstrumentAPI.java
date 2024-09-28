package com.tradingbot.versbot;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class InstrumentAPI extends BaseAPI {

    private static final String TAG = "InstrumentAPI";

    public InstrumentAPI(Context context) {
        super(context);
    }

    public String getCandles(String instrument, String granularity, int count) throws Exception {
        log("Fetching candles for instrument: " + instrument + ", granularity: " + granularity + ", count: " + count);
        return makeRequest("/v3/instruments/" + instrument + "/candles?granularity=" + granularity + "&count=" + count, "GET", null, false);
    }

    public String getOrderBook(String instrument) throws Exception {
        return makeRequest("/v3/instruments/" + instrument + "/orderBook", "GET", null, false);
    }

    public String getPositionBook(String instrument) throws Exception {
        return makeRequest("/v3/instruments/" + instrument + "/positionBook", "GET", null, false);
    }

    private void log(String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
        Logger.getInstance(null).log(timestamp + " - " + message);
    }
}
