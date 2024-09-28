package com.tradingbot.versbot;

import android.content.Context;

public class AccountAPI extends BaseAPI {

    public AccountAPI(Context context) {
        super(context);
    }

    public String getAccounts() throws Exception {
        return makeRequest("/v3/accounts", "GET", null, false);
    }

    public String getAccountDetails() throws Exception {
        return makeRequest("/v3/accounts/" + ACCOUNT_ID, "GET", null, false);
    }

    public String getAccountSummary() throws Exception {
        return makeRequest("/v3/accounts/" + ACCOUNT_ID + "/summary", "GET", null, false);
    }

    public String getAccountInstruments() throws Exception {
        return makeRequest("/v3/accounts/" + ACCOUNT_ID + "/instruments", "GET", null, false);
    }

    public String updateAccountConfiguration(String body) throws Exception {
        return makeRequest("/v3/accounts/" + ACCOUNT_ID + "/configuration", "PATCH", body, false);
    }

    public String getAccountChanges(String transactionId) throws Exception {
        return makeRequest("/v3/accounts/" + ACCOUNT_ID + "/changes?sinceTransactionID=" + transactionId, "GET", null, false);
    }
}
