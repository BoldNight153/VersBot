package com.tradingbot.versbot;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Button;
import org.json.JSONObject;

public class MainActivity extends Activity {

    private TextView aliasTextView;
    private TextView idTextView;
    private LinearLayout dataLayout;
    private Account account; // Global scope for Account object
    private AccountAPI accountAPI; // Global scope for AccountAPI object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize AccountAPI
        accountAPI = new AccountAPI(this);

        // Initialize views
        aliasTextView = findViewById(R.id.aliasTextView);
        idTextView = findViewById(R.id.idTextView);
        dataLayout = findViewById(R.id.dataLayout);
        Button getAccountDetailsButton = findViewById(R.id.getAccountDetailsButton);

        // Set onClickListener for the button
        getAccountDetailsButton.setOnClickListener(v -> getAccountDetails());

        // Call getAccountDetails when MainActivity is loaded
        getAccountDetails();
    }

    private void getAccountDetails() {
        new GetAccountDetailsTask(this).execute();
    }

    private void updateUI() {
        if (account != null) {
            aliasTextView.setText(account.getAlias());
            idTextView.setText(account.getId());

            dataLayout.removeAllViews();
            addDataPoint("Guaranteed Stop Loss Order Mode", account.getGuaranteedStopLossOrderMode());
            addDataPoint("Hedging Enabled", String.valueOf(account.isHedgingEnabled()));
            addDataPoint("Created Time", account.getCreatedTime());
            addDataPoint("Currency", account.getCurrency());
            addDataPoint("Created By User ID", String.valueOf(account.getCreatedByUserID()));
            addDataPoint("Margin Rate", account.getMarginRate());
            addDataPoint("Last Transaction ID", account.getLastTransactionID());
            addDataPoint("Balance", account.getBalance());
            addDataPoint("Open Trade Count", String.valueOf(account.getOpenTradeCount()));
            addDataPoint("Open Position Count", String.valueOf(account.getOpenPositionCount()));
            addDataPoint("Pending Order Count", String.valueOf(account.getPendingOrderCount()));
            addDataPoint("P/L", account.getPl());
            addDataPoint("Resettable P/L", account.getResettablePL());
            addDataPoint("Resettable P/L Time", account.getResettablePLTime());
            addDataPoint("Financing", account.getFinancing());
            addDataPoint("Commission", account.getCommission());
            addDataPoint("Dividend Adjustment", account.getDividendAdjustment());
            addDataPoint("Guaranteed Execution Fees", account.getGuaranteedExecutionFees());
            addDataPoint("Unrealized P/L", account.getUnrealizedPL());
            addDataPoint("NAV", account.getNAV());
            addDataPoint("Margin Used", account.getMarginUsed());
            addDataPoint("Margin Available", account.getMarginAvailable());
            addDataPoint("Position Value", account.getPositionValue());
            addDataPoint("Margin Closeout Unrealized P/L", account.getMarginCloseoutUnrealizedPL());
            addDataPoint("Margin Closeout NAV", account.getMarginCloseoutNAV());
            addDataPoint("Margin Closeout Margin Used", account.getMarginCloseoutMarginUsed());
            addDataPoint("Margin Closeout Position Value", account.getMarginCloseoutPositionValue());
            addDataPoint("Margin Closeout Percent", account.getMarginCloseoutPercent());
            addDataPoint("Withdrawal Limit", account.getWithdrawalLimit());
            addDataPoint("Margin Call Margin Used", account.getMarginCallMarginUsed());
            addDataPoint("Margin Call Percent", account.getMarginCallPercent());
        }
    }

    private void addDataPoint(String label, String value) {
        View dataPointView = getLayoutInflater().inflate(R.layout.data_point, null);
        TextView labelTextView = dataPointView.findViewById(R.id.labelTextView);
        TextView valueTextView = dataPointView.findViewById(R.id.valueTextView);
        labelTextView.setText(label);
        valueTextView.setText(value);
        dataLayout.addView(dataPointView);
    }

    private static class GetAccountDetailsTask extends AsyncTask<Void, Void, String> {

        private final Context context;

        GetAccountDetailsTask(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                MainActivity activity = (MainActivity) context;
                return activity.accountAPI.getAccountDetails();
            } catch (Exception e) {
                return "Error: " + e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Log.d("GetAccountDetailsTask", "Account Details: " + result);
            try {
                JSONObject jsonResponse = new JSONObject(result);
                JSONObject accountJson = jsonResponse.getJSONObject("account");
                ((MainActivity) context).account = new Account(accountJson);
                ((MainActivity) context).updateUI();
            } catch (Exception e) {
                Log.d("GetAccountDetailsTask", "Error parsing account details: " + e.getMessage());
            }
        }
    }
}
