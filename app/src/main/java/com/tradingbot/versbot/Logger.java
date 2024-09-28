package com.tradingbot.versbot;

import android.content.Context;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Logger {

    private static final String TAG = "Logger";
    private static volatile Logger instance;

    private Logger(Context context) {
        // No file initialization needed
    }

    public static Logger getInstance(Context context) {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger(context);
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
        String logMessage = timestamp + " - " + message;
        Log.d(TAG, logMessage);
        // No file writing needed
    }
}
