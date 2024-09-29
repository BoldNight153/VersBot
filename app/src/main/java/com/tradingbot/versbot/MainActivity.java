package com.tradingbot.versbot;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MainActivity extends Activity {

    private ExpandableListAdapter expandableListAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;
    private Account account; // Global scope for Account object
    private AccountAPI accountAPI; // Global scope for AccountAPI object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize AccountAPI
        accountAPI = new AccountAPI(this);

        // Initialize views
        ExpandableListView expandableListView = findViewById(R.id.expandableListView);

        // Preparing list data
        prepareListData();

        expandableListAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expandableListView.setAdapter(expandableListAdapter);

        // Listview Group expanded listener
        expandableListView.setOnGroupExpandListener(groupPosition -> Toast.makeText(getApplicationContext(),
                listDataHeader.get(groupPosition) + " Expanded",
                Toast.LENGTH_SHORT).show());

        // Listview Group collasped listener
        expandableListView.setOnGroupCollapseListener(groupPosition -> Toast.makeText(getApplicationContext(),
                listDataHeader.get(groupPosition) + " Collapsed",
                Toast.LENGTH_SHORT).show());

        // Listview on child click listener
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            Toast.makeText(
                            getApplicationContext(),
                            listDataHeader.get(groupPosition)
                                    + " : "
                                    + Objects.requireNonNull(listDataChild.get(
                                    listDataHeader.get(groupPosition))).get(
                                    childPosition), Toast.LENGTH_SHORT)
                    .show();
            return false;
        });

        // Call getAccountDetails when MainActivity is loaded
        getAccountDetails();
        // Call getAccountInstruments when MainActivity is loaded
        getAccountInstruments();
    }

    private void getAccountDetails() {
        new GetAccountDetailsTask(this).execute();
    }

    private void getAccountInstruments() {
        new GetAccountInstrumentsTask(this).execute();
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding header data
        listDataHeader.add("Account Details");
        listDataHeader.add("Instruments");

        // Adding child data
        List<String> accountDetails = new ArrayList<>();
        List<String> instruments = new ArrayList<>();

        listDataChild.put(listDataHeader.get(0), accountDetails); // Header, Child data
        listDataChild.put(listDataHeader.get(1), instruments);
    }

    private void updateAccountDetailsUI() {
        if (account != null) {
            List<String> accountDetails = listDataChild.get(listDataHeader.get(0));
            assert accountDetails != null;
            accountDetails.clear();
            accountDetails.add("Alias: " + account.getAlias());
            accountDetails.add("ID: " + account.getId());
            accountDetails.add("Guaranteed Stop Loss Order Mode: " + account.getGuaranteedStopLossOrderMode());
            accountDetails.add("Hedging Enabled: " + account.isHedgingEnabled());
            accountDetails.add("Created Time: " + account.getCreatedTime());
            accountDetails.add("Currency: " + account.getCurrency());
            accountDetails.add("Created By User ID: " + account.getCreatedByUserID());
            accountDetails.add("Margin Rate: " + account.getMarginRate());
            accountDetails.add("Last Transaction ID: " + account.getLastTransactionID());
            accountDetails.add("Balance: " + account.getBalance());
            accountDetails.add("Open Trade Count: " + account.getOpenTradeCount());
            accountDetails.add("Open Position Count: " + account.getOpenPositionCount());
            accountDetails.add("Pending Order Count: " + account.getPendingOrderCount());
            accountDetails.add("P/L: " + account.getPl());
            accountDetails.add("Resettable P/L: " + account.getResettablePL());
            accountDetails.add("Resettable P/L Time: " + account.getResettablePLTime());
            accountDetails.add("Financing: " + account.getFinancing());
            accountDetails.add("Commission: " + account.getCommission());
            accountDetails.add("Dividend Adjustment: " + account.getDividendAdjustment());
            accountDetails.add("Guaranteed Execution Fees: " + account.getGuaranteedExecutionFees());
            accountDetails.add("Unrealized P/L: " + account.getUnrealizedPL());
            accountDetails.add("NAV: " + account.getNAV());
            accountDetails.add("Margin Used: " + account.getMarginUsed());
            accountDetails.add("Margin Available: " + account.getMarginAvailable());
            accountDetails.add("Position Value: " + account.getPositionValue());
            accountDetails.add("Margin Closeout Unrealized P/L: " + account.getMarginCloseoutUnrealizedPL());
            accountDetails.add("Margin Closeout NAV: " + account.getMarginCloseoutNAV());
            accountDetails.add("Margin Closeout Margin Used: " + account.getMarginCloseoutMarginUsed());
            accountDetails.add("Margin Closeout Position Value: " + account.getMarginCloseoutPositionValue());
            accountDetails.add("Margin Closeout Percent: " + account.getMarginCloseoutPercent());
            accountDetails.add("Withdrawal Limit: " + account.getWithdrawalLimit());
            accountDetails.add("Margin Call Margin Used: " + account.getMarginCallMarginUsed());
            accountDetails.add("Margin Call Percent: " + account.getMarginCallPercent());

            expandableListAdapter.notifyDataSetChanged();

            // Call getAccountInstruments after updating the account details
            getAccountInstruments();
        }
    }

    private void updateInstrumentsUI() {
        if (account != null && account.getAccountInstruments() != null) {
            List<String> instruments = listDataChild.get(listDataHeader.get(1));
            assert instruments != null;
            instruments.clear();

            try {
                JSONObject instrumentsJson = account.getAccountInstruments();
                JSONArray instrumentsArray = instrumentsJson.getJSONArray("instruments");
                for (int i = 0; i < instrumentsArray.length(); i++) {
                    JSONObject instrument = instrumentsArray.getJSONObject(i);
                    instruments.add(instrument.getString("name") + ": " + instrument.getString("displayName"));
                }
            } catch (Exception e) {
                Log.d("MainActivity", "Error parsing instruments: " + e.getMessage());
            }

            expandableListAdapter.notifyDataSetChanged();
        }
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
                ((MainActivity) context).updateAccountDetailsUI();
            } catch (Exception e) {
                Log.d("GetAccountDetailsTask", "Error parsing account details: " + e.getMessage());
            }
        }
    }

    private static class GetAccountInstrumentsTask extends AsyncTask<Void, Void, String> {

        private final Context context;

        GetAccountInstrumentsTask(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                MainActivity activity = (MainActivity) context;
                return activity.accountAPI.getAccountInstruments();
            } catch (Exception e) {
                return "Error: " + e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Log.d("GetAccountInstrumentsTask", "Account Instruments: " + result);
            try {
                JSONObject jsonResponse = new JSONObject(result);
                ((MainActivity) context).account.setAccountInstruments(jsonResponse);
                ((MainActivity) context).updateInstrumentsUI();
            } catch (Exception e) {
                Log.d("GetAccountInstrumentsTask", "Error parsing account instruments: " + e.getMessage());
            }
        }
    }
}
