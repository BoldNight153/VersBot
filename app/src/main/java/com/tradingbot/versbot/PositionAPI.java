package com.tradingbot.versbot;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PositionAPI extends BaseAPI {

    private static final String TAG = "PositionAPI";

    public PositionAPI(Context context) {
        super(context);
    }

    public String getPositions(String accountId) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/positions", "GET", null, false);
    }

    public String getOpenPositions(String accountId) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/openPositions", "GET", null, false);
    }

    public String getPositionDetails(String accountId, String instrument) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/positions/" + instrument, "GET", null, false);
    }

    public String closePosition(String accountId, String instrument) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/positions/" + instrument + "/close", "PUT", null, false);
    }

    private void log(String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
        Logger.getInstance(null).log(timestamp + " - " + message);
    }
}
