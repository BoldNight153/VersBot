//package com.tradingbot.smatestbot2;
//
//import android.util.Log;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Locale;
//
//public class BaseAPI {
//    private static final String TAG = "BaseAPI";
//    private String baseUrl;
//    private String token;
//    private RateLimiter rateLimiter;
//
//    public BaseAPI(String baseUrl, String token) {
//        this.baseUrl = baseUrl;
//        this.token = token;
//        this.rateLimiter = RateLimiter.getInstance();
//    }
//
//    protected String makeRequest(String endpoint, String method, String body) throws Exception {
//        rateLimiter.acquireToken(); // Acquire a token before making the request
//
//        URL url = new URL(baseUrl + endpoint);
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod(method);
//        connection.setRequestProperty("Authorization", "Bearer " + token);
//        connection.setRequestProperty("Content-Type", "application/json");
//
//        log("Making request to URL: " + url.toString());
//        log("Request method: " + method);
//        log("Request body: " + body);
//
//        if (body != null && !body.isEmpty()) {
//            connection.setDoOutput(true);
//            connection.getOutputStream().write(body.getBytes());
//        }
//
//        int responseCode = connection.getResponseCode();
//        log("Response code: " + responseCode);
//
//        if (responseCode == 200 || responseCode == 201) {
//            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String inputLine;
//            StringBuilder response = new StringBuilder();
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//            log("Response: " + response.toString());
//            return response.toString();
//        } else {
//            throw new Exception("HTTP error code: " + responseCode);
//        }
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

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaseAPI {
    private static final String TAG = "BaseAPI";
    private String baseUrl;
    private String token;
    private RateLimiter rateLimiter;
    private Logger logger;

    public BaseAPI(String baseUrl, String token, Context context) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.rateLimiter = RateLimiter.getInstance();
        this.logger = Logger.getInstance(context);
    }

    protected String makeRequest(String endpoint, String method, String body) throws Exception {
        rateLimiter.acquireToken(); // Acquire a token before making the request

        URL url = new URL(baseUrl + endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.setRequestProperty("Authorization", "Bearer " + token);
        connection.setRequestProperty("Content-Type", "application/json");


        Log.d("Making request to URL: ", url.toString());
        Log.d("Request Method: ", "Reqeust Method" + method);
        Log.d("Reqeust body: ", "Request body: " + body);
        logger.log("Making request to URL: " + url.toString());
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
            logger.log("Response: " + response.toString());
            Log.d("Raw Response String: ", "Raw Response String: " + response.toString());
            return response.toString();
        } else {
            throw new Exception("HTTP error code: " + responseCode);
        }
    }
}
