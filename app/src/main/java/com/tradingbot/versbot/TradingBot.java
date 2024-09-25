//package com.tradingbot.smatestbot2;
//
//import android.util.Log;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;
//import java.util.Timer;
//import java.util.TimerTask;
//
//public class TradingBot {
//
//    private static final String TAG = "TradingBot";
//    private InstrumentAPI instrumentAPI;
//    private OrderAPI orderAPI;
//    private TradeAPI tradeAPI;
//    private PositionAPI positionAPI;
//    private Timer timer;
//    private boolean isRunning;
//
//    public TradingBot(String baseUrl, String token) {
//        instrumentAPI = new InstrumentAPI(baseUrl, token);
//        orderAPI = new OrderAPI(baseUrl, token);
//        tradeAPI = new TradeAPI(baseUrl, token);
//        positionAPI = new PositionAPI(baseUrl, token);
//        isRunning = false;
//    }
//
//    public void startTrading(String instrument, String accountId) {
//        if (isRunning) return;
//        isRunning = true;
//        log("Starting trading for instrument: " + instrument + ", accountId: " + accountId);
//        timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                try {
//                    // Fetch historical price data
//                    String response = instrumentAPI.getCandles(instrument, "H1", 100);
//                    log("Fetched historical price data: " + response);
//                    List<Double> prices = parsePrices(response);
//
//                    // Calculate SMA values
//                    List<Double> shortTermSMA = calculateSMA(prices, 10);
//                    List<Double> longTermSMA = calculateSMA(prices, 50);
//                    log("Calculated short-term SMA: " + shortTermSMA.toString());
//                    log("Calculated long-term SMA: " + longTermSMA.toString());
//
//                    // Check for SMA crossovers
//                    checkForCrossover(shortTermSMA, longTermSMA, accountId);
//
//                } catch (Exception e) {
//                    handleError(e);
//                }
//            }
//        }, 0, 60000); // Run every minute
//    }
//
//    public void stopTrading() {
//        if (!isRunning) return;
//        isRunning = false;
//        if (timer != null) {
//            timer.cancel();
//        }
//        log("Stopped trading");
//    }
//
//    private List<Double> parsePrices(String response) {
//        List<Double> prices = new ArrayList<>();
//        try {
//            JSONObject jsonResponse = new JSONObject(response);
//            JSONArray candles = jsonResponse.getJSONArray("candles");
//            for (int i = 0; i < candles.length(); i++) {
//                JSONObject candle = candles.getJSONObject(i);
//                JSONObject mid = candle.getJSONObject("mid");
//                double closePrice = mid.getDouble("c");
//                prices.add(closePrice);
//                log("Parsed price: " + closePrice);
//            }
//        } catch (Exception e) {
//            log("Error parsing prices: " + e.getMessage());
//        }
//        return prices;
//    }
//
//    private List<Double> calculateSMA(List<Double> prices, int period) {
//        List<Double> smaValues = new ArrayList<>();
//        for (int i = 0; i <= prices.size() - period; i++) {
//            double sum = 0;
//            for (int j = i; j < i + period; j++) {
//                sum += prices.get(j);
//            }
//            double sma = sum / period;
//            smaValues.add(sma);
//            log("Calculated SMA: " + sma);
//        }
//        return smaValues;
//    }
//
//    private void checkForCrossover(List<Double> shortTermSMA, List<Double> longTermSMA, String accountId) {
//        for (int i = 1; i < shortTermSMA.size(); i++) {
//            if (shortTermSMA.get(i) > longTermSMA.get(i) && shortTermSMA.get(i - 1) <= longTermSMA.get(i - 1)) {
//                // Buy signal
//                placeOrder("buy", accountId);
//            } else if (shortTermSMA.get(i) < longTermSMA.get(i) && shortTermSMA.get(i - 1) >= longTermSMA.get(i - 1)) {
//                // Sell signal
//                placeOrder("sell", accountId);
//            }
//        }
//    }
//
//    private void placeOrder(String orderType, String accountId) {
//        try {
//            Map<String, Object> orderData = new HashMap<>();
//            orderData.put("order", new JSONObject()
//                    .put("instrument", "EUR_USD")
//                    .put("units", orderType.equals("buy") ? 100 : -100)
//                    .put("type", "MARKET")
//                    .put("timeInForce", "FOK")
//                    .put("positionFill", "DEFAULT"));
//
//            String response = orderAPI.createOrder(accountId, orderData);
//            log("Order Response: " + response);
//        } catch (Exception e) {
//            log("Error placing order: " + e.getMessage());
//        }
//    }
//
//    private void handleError(Exception e) {
//        log("Error: " + e.getMessage());
//        e.printStackTrace();
//    }
//
//    public boolean isRunning() {
//        return isRunning;
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
import org.json.JSONArray;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class TradingBot {

    private static final String TAG = "TradingBot";
    private InstrumentAPI instrumentAPI;
    private OrderAPI orderAPI;
    private TradeAPI tradeAPI;
    private PositionAPI positionAPI;
    private Timer timer;
    private boolean isRunning;
    private Logger logger;

    public TradingBot(String baseUrl, String token, Context context) {
        instrumentAPI = new InstrumentAPI(baseUrl, token, context);
        orderAPI = new OrderAPI(baseUrl, token, context);
        tradeAPI = new TradeAPI(baseUrl, token, context);
        positionAPI = new PositionAPI(baseUrl, token, context);
        isRunning = false;
        logger = Logger.getInstance(context);
    }

    public void startTrading(String instrument, String accountId) {
        if (isRunning) return;
        isRunning = true;
        logger.log("Starting trading for instrument: " + instrument + ", accountId: " + accountId);
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    // Fetch historical price data
                    String response = instrumentAPI.getCandles(instrument, "H1", 100);
                    logger.log("Fetched historical price data: " + response);
                    List<Double> prices = parsePrices(response);

                    // Calculate SMA values
                    List<Double> shortTermSMA = calculateSMA(prices, 10);
                    List<Double> longTermSMA = calculateSMA(prices, 50);
                    logger.log("Calculated short-term SMA: " + shortTermSMA.toString());
                    logger.log("Calculated long-term SMA: " + longTermSMA.toString());

                    // Check for SMA crossovers
                    checkForCrossover(shortTermSMA, longTermSMA, accountId);

                } catch (Exception e) {
                    handleError(e);
                }
            }
        }, 0, 60000); // Run every minute
    }

    public void stopTrading() {
        if (!isRunning) return;
        isRunning = false;
        if (timer != null) {
            timer.cancel();
        }
        logger.log("Stopped trading");
    }

    private List<Double> parsePrices(String response) {
        List<Double> prices = new ArrayList<>();
        try {
            JSONObject jsonResponse = new JSONObject(response);
            JSONArray candles = jsonResponse.getJSONArray("candles");
            for (int i = 0; i < candles.length(); i++) {
                JSONObject candle = candles.getJSONObject(i);
                JSONObject mid = candle.getJSONObject("mid");
                double closePrice = mid.getDouble("c");
                prices.add(closePrice);
                logger.log("Parsed price: " + closePrice);
            }
        } catch (Exception e) {
            logger.log("Error parsing prices: " + e.getMessage());
        }
        return prices;
    }

    private List<Double> calculateSMA(List<Double> prices, int period) {
        List<Double> smaValues = new ArrayList<>();
        for (int i = 0; i <= prices.size() - period; i++) {
            double sum = 0;
            for (int j = i; j < i + period; j++) {
                sum += prices.get(j);
            }
            double sma = sum / period;
            smaValues.add(sma);
            logger.log("Calculated SMA: " + sma);
        }
        return smaValues;
    }

    private void checkForCrossover(List<Double> shortTermSMA, List<Double> longTermSMA, String accountId) {
        for (int i = 1; i < shortTermSMA.size(); i++) {
            if (shortTermSMA.get(i) > longTermSMA.get(i) && shortTermSMA.get(i - 1) <= longTermSMA.get(i - 1)) {
                // Buy signal
                placeOrder("buy", accountId);
            } else if (shortTermSMA.get(i) < longTermSMA.get(i) && shortTermSMA.get(i - 1) >= longTermSMA.get(i - 1)) {
                // Sell signal
                placeOrder("sell", accountId);
            }
        }
    }

    private void placeOrder(String orderType, String accountId) {
        try {
            Map<String, Object> orderData = new HashMap<>();
            orderData.put("order", new JSONObject()
                    .put("instrument", "EUR_USD")
                    .put("units", orderType.equals("buy") ? 100 : -100)
                    .put("type", "MARKET")
                    .put("timeInForce", "FOK")
                    .put("positionFill", "DEFAULT"));

            String response = orderAPI.createOrder(accountId, orderData);
            logger.log("Order Response: " + response);
        } catch (Exception e) {
            logger.log("Error placing order: " + e.getMessage());
        }
    }

    private void handleError(Exception e) {
        logger.log("Error: " + e.getMessage());
        e.printStackTrace();
    }

    public boolean isRunning() {
        return isRunning;
    }
}

