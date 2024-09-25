//package com.tradingbot.smatestbot2;
//
//import java.util.Map;
//
//// AccountAPI class
//public class AccountAPI extends BaseAPI {
//
//    public AccountAPI(String baseUrl, String token) {
//        super(baseUrl, token);
//    }
//
//    public String getAccounts() throws Exception {
//        return makeRequest("/v3/accounts", "GET", null);
//    }
//
//    public String getAccountDetails(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId, "GET", null);
//    }
//
//    public String getAccountSummary(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/summary", "GET", null);
//    }
//
//    public String getAccountInstruments(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/instruments", "GET", null);
//    }
//
//    public String setAccountConfiguration(String accountId, Map<String, String> configData) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/configuration", "PATCH", configData);
//    }
//
//    public String getAccountChanges(String accountId, String transactionId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/changes?sinceTransactionID=" + transactionId, "GET", null);
//    }
//}


//package com.tradingbot.smatestbot2;
//
//public class AccountAPI extends BaseAPI {
//
//    public AccountAPI(String baseUrl, String token) {
//        super(baseUrl, token);
//    }
//
//    public String getAccounts() throws Exception {
//        return makeRequest("/v3/accounts", "GET", null);
//    }
//
//    public String getAccountDetails(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId, "GET", null);
//    }
//
//    public String getAccountSummary(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/summary", "GET", null);
//    }
//
//    public String getAccountInstruments(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/instruments", "GET", null);
//    }
//
//    public String updateAccountConfiguration(String accountId, String body) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/configuration", "PATCH", body);
//    }
//
//    public String getAccountChanges(String accountId, String transactionId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/changes?sinceTransactionID=" + transactionId, "GET", null);
//    }
//
//    public String getAccountTransactions(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/transactions", "GET", null);
//    }
//
//    public String getAccountTransactionDetails(String accountId, String transactionId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/transactions/" + transactionId, "GET", null);
//    }
//
//    public String getAccountTransactionIdRange(String accountId, String fromId, String toId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/transactions/idrange?from=" + fromId + "&to=" + toId, "GET", null);
//    }
//
//    public String getAccountTransactionsSinceId(String accountId, String sinceId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/transactions/sinceid?id=" + sinceId, "GET", null);
//    }
//
//    public String getAccountTransactionsStream(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/transactions/stream", "GET", null);
//    }
//
//    public String getAccountCandlesLatest(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/candles/latest", "GET", null);
//    }
//
//    public String getAccountPricing(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/pricing", "GET", null);
//    }
//
//    public String getAccountPricingStream(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/pricing/stream", "GET", null);
//    }
//}


package com.tradingbot.versbot;

import android.content.Context;

public class AccountAPI extends BaseAPI {

    public AccountAPI(String baseUrl, String token, Context context) {
        super(baseUrl, token, context);
    }

    public String getAccounts() throws Exception {
        return makeRequest("/v3/accounts", "GET", null);
    }

    public String getAccountDetails(String accountId) throws Exception {
        return makeRequest("/v3/accounts/" + accountId, "GET", null);
    }

    public String getAccountSummary(String accountId) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/summary", "GET", null);
    }

    public String getAccountInstruments(String accountId) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/instruments", "GET", null);
    }

    public String updateAccountConfiguration(String accountId, String body) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/configuration", "PATCH", body);
    }

    public String getAccountChanges(String accountId, String transactionId) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/changes?sinceTransactionID=" + transactionId, "GET", null);
    }
}
