package com.tradingbot.versbot;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaseAPI {
    // Access token for making api calls
    private static final String ACCESS_TOKEN = "47bf7d45728cd122c3502d0e9602f49c-5d2e542fdb2455494926f88c012fe544";

    // Endpoint base URLs
    private static final String fxTradePractice_REST_Base_URL = "https://api-fxpractice.oanda.com";
    private static final String fxTradePractice_Stream_Base_URL = "https://api-fxpractice.oanda.com";

    // Account ID constant
    protected static final String ACCOUNT_ID = "101-001-29899550-001";

    private static String baseUrl = "";

    private final Logger logger;

    public BaseAPI(Context context) {
        this.logger = Logger.getInstance(context);
    }

    protected String makeRequest(String endpoint, String method, String body, Boolean isStream) throws Exception {
        if (isStream == null) {
            baseUrl = fxTradePractice_REST_Base_URL;
        } else {
            baseUrl = fxTradePractice_Stream_Base_URL;
        }

        URL url = new URL(baseUrl + endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);
        connection.setRequestProperty("Content-Type", "application/json");

        logger.log("Making request to URL: " + url);
        logger.log("Request method: " + method);
        logger.log("Request body: " + body);

        if (body != null && !body.isEmpty()) {
            connection.setDoOutput(true);
            connection.getOutputStream().write(body.getBytes());
        }

        int responseCode = connection.getResponseCode();
        logger.log("Response code: " + responseCode);

        if (responseCode == 200 || responseCode == 201) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            logger.log("Response: " + response);
            return response.toString();
        } else {
            throw new Exception("HTTP error code: " + responseCode);
        }
    }
}
