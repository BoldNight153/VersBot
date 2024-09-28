package com.tradingbot.versbot;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PricingAPI extends BaseAPI {

    private static final String TAG = "PricingAPI";

    public PricingAPI(Context context) {
        super(context);
    }

    public String getPricing(String accountId) throws Exception {
        log("Fetching pricing for account: " + accountId);
        return makeRequest("/v3/accounts/" + accountId + "/pricing", "GET", null, false);
    }

    public String getPricingStream(String accountId) throws Exception {
        log("Fetching pricing stream for account: " + accountId);
        return makeRequest("/v3/accounts/" + accountId + "/pricing/stream", "GET", null, false);
    }

    private void log(String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
        Logger.getInstance(null).log(timestamp + " - " + message);
    }
}
