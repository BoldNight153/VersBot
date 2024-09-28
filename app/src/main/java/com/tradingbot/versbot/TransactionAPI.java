package com.tradingbot.versbot;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TransactionAPI extends BaseAPI {

    private static final String TAG = "TransactionAPI";

    public TransactionAPI(Context context) {
        super(context);
    }

    public String getTransactions(String accountId) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/transactions", "GET", null, false);
    }

    public String getTransactionDetails(String accountId, String transactionId) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/transactions/" + transactionId, "GET", null, false);
    }

    public String getTransactionIdRange(String accountId, String fromId, String toId) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/transactions/idrange?from=" + fromId + "&to=" + toId, "GET", null, false);
    }

    public String getTransactionsSinceId(String accountId, String sinceId) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/transactions/sinceid?id=" + sinceId, "GET", null, false);
    }

    public String getTransactionsStream(String accountId) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/transactions/stream", "GET", null, false);
    }
}
