package com.tradingbot.versbot;

// Utilities class
public class Utilities {
    public static void manageRateLimiting() {
        // Implement rate limiting logic here
    }

    public static String getEnvironmentUrl(String environment) {
        if (environment.equals("fxTrade")) {
            return "https://api-fxtrade.oanda.com";

        } else if (environment.equals("fxPractice")) {
            return "https://api-fxpractice.oanda.com";
        }
        return null;
    }
}
