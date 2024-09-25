//package com.tradingbot.smatestbot2;
//
//import android.util.Log;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Locale;
//
//public class TransactionAPI extends BaseAPI {
//
//    private static final String TAG = "TransactionsAPI";
//
//    public TransactionAPI(String baseUrl, String token) {
//        super(baseUrl, token);
//    }
//
//    public String getTransactions(String accountId) throws Exception {
//        log("Fetching transactions for account: " + accountId);
//        return makeRequest("/v3/accounts/" + accountId + "/transactions", "GET", null);
//    }
//
//    public String getTransactionDetails(String accountId, String transactionId) throws Exception {
//        log("Fetching transaction details for account: " + accountId + ", transactionId: " + transactionId);
//        return makeRequest("/v3/accounts/" + accountId + "/transactions/" + transactionId, "GET", null);
//    }
//
//    public String getTransactionIdRange(String accountId, String fromId, String toId) throws Exception {
//        log("Fetching transaction ID range for account: " + accountId + ", fromId: " + fromId + ", toId: " + toId);
//        return makeRequest("/v3/accounts/" + accountId + "/transactions/idrange?from=" + fromId + "&to=" + toId, "GET", null);
//    }
//
//    public String getTransactionsSinceId(String accountId, String sinceId) throws Exception {
//        log("Fetching transactions since ID for account: " + accountId + ", sinceId: " + sinceId);
//        return makeRequest("/v3/accounts/" + accountId + "/transactions/sinceid?id=" + sinceId, "GET", null);
//    }
//
//    public String getTransactionsStream(String accountId) throws Exception {
//        log("Fetching transactions stream for account: " + accountId);
//        return makeRequest("/v3/accounts/" + accountId + "/transactions/stream", "GET", null);
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

public class TransactionAPI extends BaseAPI {

    private static final String TAG = "TransactionAPI";

    public TransactionAPI(String baseUrl, String token, Context context) {
        super(baseUrl, token, context);
    }

    public String getTransactions(String accountId) throws Exception {
        log("Fetching transactions for account: " + accountId);
        return makeRequest("/v3/accounts/" + accountId + "/transactions", "GET", null);
    }

    public String getTransactionDetails(String accountId, String transactionId) throws Exception {
        log("Fetching transaction details for account: " + accountId + ", transactionId: " + transactionId);
        return makeRequest("/v3/accounts/" + accountId + "/transactions/" + transactionId, "GET", null);
    }

    public String getTransactionIdRange(String accountId, String fromId, String toId) throws Exception {
        log("Fetching transaction ID range for account: " + accountId + ", fromId: " + fromId + ", toId: " + toId);
        return makeRequest("/v3/accounts/" + accountId + "/transactions/idrange?from=" + fromId + "&to=" + toId, "GET", null);
    }

    public String getTransactionsSinceId(String accountId, String sinceId) throws Exception {
        log("Fetching transactions since ID for account: " + accountId + ", sinceId: " + sinceId);
        return makeRequest("/v3/accounts/" + accountId + "/transactions/sinceid?id=" + sinceId, "GET", null);
    }

    public String getTransactionsStream(String accountId) throws Exception {
        log("Fetching transactions stream for account: " + accountId);
        return makeRequest("/v3/accounts/" + accountId + "/transactions/stream", "GET", null);
    }

    private void log(String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
        Log.d(TAG, timestamp + " - " + message);
    }
}
