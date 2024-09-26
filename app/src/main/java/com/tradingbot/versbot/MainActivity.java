////package com.tradingbot.smatestbot2;
////
////import android.os.Bundle;
////import android.util.Log;
////import android.view.View;
////import android.widget.AdapterView;
////import android.widget.ListView;
////import android.widget.Toast;
////
////import androidx.appcompat.app.AppCompatActivity;
////
////import org.json.JSONArray;
////import org.json.JSONObject;
////
////import java.text.SimpleDateFormat;
////import java.util.ArrayList;
////import java.util.Date;
////import java.util.List;
////import java.util.Locale;
////
////public class MainActivity extends AppCompatActivity {
////
////    private static final String TAG = "MainActivity";
////    private AccountAPI accountAPI;
////    private ListView accountsListView;
////    private List<Account> accounts;
////    private TradingBot tradingBot;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
////
////        accountsListView = findViewById(R.id.accountsListView);
////
////        // Initialize AccountAPI with base URL and token
////        accountAPI = new AccountAPI("https://api-fxpractice.oanda.com", "47bf7d45728cd122c3502d0e9602f49c-5d2e542fdb2455494926f88c012fe544");
////
////        // Initialize TradingBot
////        tradingBot = new TradingBot("https://api-fxpractice.oanda.com", "47bf7d45728cd122c3502d0e9602f49c-5d2e542fdb2455494926f88c012fe544");
////
////        // Fetch accounts and display them
////        fetchAccounts();
////    }
////
////    private void fetchAccounts() {
////        new Thread(() -> {
////            try {
////                log("Fetching accounts...");
////                String response = accountAPI.getAccounts();
////                log("API Response: " + response);
////                accounts = parseAccounts(response);
////                log("Parsed Accounts: " + accounts.toString());
////
////                runOnUiThread(() -> {
////                    if (accounts.isEmpty()) {
////                        Toast.makeText(MainActivity.this, "No accounts found", Toast.LENGTH_SHORT).show();
////                    } else {
////                        AccountAdapter adapter = new AccountAdapter(MainActivity.this, accounts);
////                        accountsListView.setAdapter(adapter);
////                        accountsListView.setOnItemClickListener((parent, view, position, id) -> {
////                            Account selectedAccount = accounts.get(position);
////                            log("Selected Account: " + selectedAccount.toString());
////                            if (tradingBot.isRunning()) {
////                                tradingBot.stopTrading();
////                                selectedAccount.setStatus("Stopped");
////                                log("Trading stopped for account: " + selectedAccount.getId());
////                            } else {
////                                tradingBot.startTrading("EUR_USD", selectedAccount.getId());
////                                selectedAccount.setStatus("Running");
////                                log("Trading started for account: " + selectedAccount.getId());
////                            }
////                            adapter.notifyDataSetChanged();
////                        });
////                    }
////                });
////            } catch (Exception e) {
////                runOnUiThread(() -> Toast.makeText(MainActivity.this, "Failed to fetch accounts", Toast.LENGTH_SHORT).show());
////                log("Error fetching accounts: " + e.getMessage());
////            }
////        }).start();
////    }
////
////    private List<Account> parseAccounts(String response) {
////        List<Account> accounts = new ArrayList<>();
////        try {
////            JSONObject jsonResponse = new JSONObject(response);
////            JSONArray accountsArray = jsonResponse.getJSONArray("accounts");
////            for (int i = 0; i < accountsArray.length(); i++) {
////                JSONObject accountObject = accountsArray.getJSONObject(i);
////                String id = accountObject.getString("id");
////                String status = "Stopped"; // Default status
////                String alias = accountObject.optString("alias", "").trim(); // Get alias if available and trim spaces
////                if (alias.isEmpty()) {
////                    alias = "No Alias from Oanda Account"; // Set default alias if alias is null, empty, or contains only spaces
////                }
////                Account account = new Account(id, status, alias);
////                accounts.add(account);
////                log("Parsed Account: " + account.toString());
////            }
////        } catch (Exception e) {
////            log("Error parsing accounts: " + e.getMessage());
////        }
////        return accounts;
////    }
////
////    private void log(String message) {
////        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
////        Log.d(TAG, timestamp + " - " + message);
////    }
////}
//
//
////package com.tradingbot.smatestbot2;
////
////import android.os.Bundle;
////import android.widget.ListView;
////import android.widget.Toast;
////
////import androidx.appcompat.app.AppCompatActivity;
////
////import org.json.JSONArray;
////import org.json.JSONObject;
////
////import java.util.ArrayList;
////import java.util.List;
////
////public class MainActivity extends AppCompatActivity {
////
////    private static final String TAG = "MainActivity";
////    private AccountAPI accountAPI;
////    private ListView accountsListView;
////    private List<Account> accounts;
////    private TradingBot tradingBot;
////    private Logger logger;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
////
////        accountsListView = findViewById(R.id.accountsListView);
////        logger = Logger.getInstance(this);
////
////        // Initialize AccountAPI with base URL and token
////        accountAPI = new AccountAPI("https://api-fxpractice.oanda.com", "47bf7d45728cd122c3502d0e9602f49c-5d2e542fdb2455494926f88c012fe544");
////
////        // Initialize TradingBot
////        tradingBot = new TradingBot("https://api-fxpractice.oanda.com", "47bf7d45728cd122c3502d0e9602f49c-5d2e542fdb2455494926f88c012fe544");
////
////        // Fetch accounts and display them
////        fetchAccounts();
////    }
////
////    private void fetchAccounts() {
////        new Thread(() -> {
////            try {
////                logger.log("Fetching accounts...");
////                String response = accountAPI.getAccounts();
////                logger.log("API Response: " + response);
////                accounts = parseAccounts(response);
////                logger.log("Parsed Accounts: " + accounts.toString());
////
////                runOnUiThread(() -> {
////                    if (accounts.isEmpty()) {
////                        Toast.makeText(MainActivity.this, "No accounts found", Toast.LENGTH_SHORT).show();
////                    } else {
////                        AccountAdapter adapter = new AccountAdapter(MainActivity.this, accounts);
////                        accountsListView.setAdapter(adapter);
////                        accountsListView.setOnItemClickListener((parent, view, position, id) -> {
////                            Account selectedAccount = accounts.get(position);
////                            logger.log("Selected Account: " + selectedAccount.toString());
////                            if (tradingBot.isRunning()) {
////                                tradingBot.stopTrading();
////                                selectedAccount.setStatus("Stopped");
////                                logger.log("Trading stopped for account: " + selectedAccount.getId());
////                            } else {
////                                tradingBot.startTrading("EUR_USD", selectedAccount.getId());
////                                selectedAccount.setStatus("Running");
////                                logger.log("Trading started for account: " + selectedAccount.getId());
////                            }
////                            adapter.notifyDataSetChanged();
////                        });
////                    }
////                });
////            } catch (Exception e) {
////                runOnUiThread(() -> Toast.makeText(MainActivity.this, "Failed to fetch accounts", Toast.LENGTH_SHORT).show());
////                logger.log("Error fetching accounts: " + e.getMessage());
////            }
////        }).start();
////    }
////
////    private List<Account> parseAccounts(String response) {
////        List<Account> accounts = new ArrayList<>();
////        try {
////            JSONObject jsonResponse = new JSONObject(response);
////            JSONArray accountsArray = jsonResponse.getJSONArray("accounts");
////            for (int i = 0; i < accountsArray.length(); i++) {
////                JSONObject accountObject = accountsArray.getJSONObject(i);
////                String id = accountObject.getString("id");
////                String status = "Stopped"; // Default status
////                String alias = accountObject.optString("alias", "").trim(); // Get alias if available and trim spaces
////                if (alias.isEmpty()) {
////                    alias = "No Alias from Oanda Account"; // Set default alias if alias is null, empty, or contains only spaces
////                }
////                Account account = new Account(id, status, alias);
////                accounts.add(account);
////                logger.log("Parsed Account: " + account.toString());
////            }
////        } catch (Exception e) {
////            logger.log("Error parsing accounts: " + e.getMessage());
////        }
////        return accounts;
////    }
////}


//package com.tradingbot.versbot;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//
//    private static final String TAG = "MainActivity";
//    private AccountAPI accountAPI;
//    private ListView accountsListView;
//    private List<Account> accounts;
//    private TradingBot tradingBot;
//    private Logger logger;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        accountsListView = findViewById(R.id.accountsListView);
//        logger = Logger.getInstance(this);
//
//        // Initialize AccountAPI with base URL and token
//        accountAPI = new AccountAPI("https://api-fxpractice.oanda.com", "47bf7d45728cd122c3502d0e9602f49c-5d2e542fdb2455494926f88c012fe544", this);
//
//        // Initialize TradingBot
//        tradingBot = new TradingBot("https://api-fxpractice.oanda.com", "47bf7d45728cd122c3502d0e9602f49c-5d2e542fdb2455494926f88c012fe544", this);
//
//        // Fetch accounts and display them
//        fetchAccounts();
//    }
//
//    private void fetchAccounts() {
//        new Thread(() -> {
//            try {
//                logger.log("Fetching accounts...");
//                String response = accountAPI.getAccounts();
//                Log.d("Direct response from getAccounts(): ", response);
//                logger.log("API Response: " + response);
//                accounts = parseAccounts(response);
//                logger.log("Parsed Accounts: " + accounts.toString());
//
//                runOnUiThread(() -> {
//                    if (accounts.isEmpty()) {
//                        Toast.makeText(MainActivity.this, "No accounts found", Toast.LENGTH_SHORT).show();
//                    } else {
//                        AccountAdapter adapter = new AccountAdapter(MainActivity.this, accounts);
//                        accountsListView.setAdapter(adapter);
//                        accountsListView.setOnItemClickListener((parent, view, position, id) -> {
//                            Account selectedAccount = accounts.get(position);
//                            logger.log("Selected Account: " + selectedAccount.toString());
//                            if (tradingBot.isRunning()) {
//                                tradingBot.stopTrading();
//                                selectedAccount.setStatus("Stopped");
//                                logger.log("Trading stopped for account: " + selectedAccount.getId());
//                            } else {
//                                tradingBot.startTrading("EUR_USD", selectedAccount.getId());
//                                selectedAccount.setStatus("Running");
//                                logger.log("Trading started for account: " + selectedAccount.getId());
//                            }
//                            adapter.notifyDataSetChanged();
//                        });
//                    }
//                });
//            } catch (Exception e) {
//                runOnUiThread(() -> Toast.makeText(MainActivity.this, "Failed to fetch accounts", Toast.LENGTH_SHORT).show());
//                logger.log("Error fetching accounts: " + e.getMessage());
//            }
//        }).start();
//    }
//
//    private List<Account> parseAccounts(String response) {
//
//        List<Account> accounts = new ArrayList<>();
//        try {
//            JSONObject jsonResponse = new JSONObject(response);
//            Log.d("Accounts response: ", jsonResponse.toString());
//            JSONArray accountsArray = jsonResponse.getJSONArray("accounts");
//            for (int i = 0; i < accountsArray.length(); i++) {
//                JSONObject accountObject = accountsArray.getJSONObject(i);
//                String id = accountObject.getString("id");
//                String status = "Stopped"; // Default status
//                String alias = accountObject.optString("alias", "").trim(); // Get alias if available and trim spaces
//                if (alias.isEmpty()) {
//                    alias = "No Alias from Oanda Account"; // Set default alias if alias is null, empty, or contains only spaces
//                }
//                Account account = new Account(id, status, alias);
//                accounts.add(account);
//                logger.log("Parsed Account: " + account.toString());
//            }
//        } catch (Exception e) {
//            logger.log("Error parsing accounts: " + e.getMessage());
//        }
//        return accounts;
//    }
//}

package com.tradingbot.versbot;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends Activity {

    private static final String ACCESS_TOKEN = "47bf7d45728cd122c3502d0e9602f49c-5d2e542fdb2455494926f88c012fe544";
    private static final String TAG = "MainActivity";

    private Button getAccountsButton;
    private Button getAccountSummaryButton;
    private TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        getAccountsButton = findViewById(R.id.getAccountsButton);
        getAccountSummaryButton = findViewById(R.id.getAccountSummaryButton);
        responseText = findViewById(R.id.responseText);

        // Set onClickListener for the buttons
        getAccountsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetAccountsTask().execute();
            }
        });

        getAccountSummaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetAccountSummaryTask().execute();
            }
        });
    }

    private class GetAccountsTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            StringBuilder response = new StringBuilder();
            try {
                URL url = new URL("https://api-fxpractice.oanda.com/v3/accounts");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);

                int responseCode = connection.getResponseCode();
                Log.d(TAG, "Response Code: " + responseCode);

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } catch (Exception e) {
                Log.e(TAG, "Error: ", e);
                response.append("Error: ").append(e.getMessage());
            }
            return response.toString();
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
                responseText.setText(result);
            } else {
                responseText.setText("Error: Response is null");
            }
        }
    }

    private class GetAccountSummaryTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            StringBuilder response = new StringBuilder();
            try {
                URL url = new URL("https://api-fxpractice.oanda.com/v3/accounts");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);

                int responseCode = connection.getResponseCode();
                Log.d(TAG, "Response Code: " + responseCode);

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse the accounts response to get account IDs
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray accounts = jsonResponse.getJSONArray("accounts");

                // Fetch account summary for each account ID
                StringBuilder summaries = new StringBuilder();
                for (int i = 0; i < accounts.length(); i++) {
                    String accountId = accounts.getJSONObject(i).getString("id");
                    summaries.append(getAccountSummary(accountId)).append("\n\n");
                }
                return summaries.toString();

            } catch (Exception e) {
                Log.e(TAG, "Error: ", e);
                response.append("Error: ").append(e.getMessage());
            }
            return response.toString();
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
                responseText.setText(result);
            } else {
                responseText.setText("Error: Response is null");
            }
        }

        private String getAccountSummary(String accountId) {
            StringBuilder response = new StringBuilder();
            try {
                URL url = new URL("https://api-fxpractice.oanda.com/v3/accounts/" + accountId + "/summary");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } catch (Exception e) {
                Log.e(TAG, "Error: ", e);
                response.append("Error: ").append(e.getMessage());
            }
            return response.toString();
        }
    }
}
