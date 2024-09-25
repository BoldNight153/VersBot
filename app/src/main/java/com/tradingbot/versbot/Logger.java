package com.tradingbot.versbot;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Logger {

    private static final String TAG = "Logger";
    private static final String LOG_FILE_NAME = "app_log.txt";
    private static Logger instance;
    private File logFile;

    private Logger(Context context) {
        File logDir = context.getFilesDir();
        logFile = new File(logDir, LOG_FILE_NAME);
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
        writeToFile(logMessage);
    }

    private void writeToFile(String message) {
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            Log.e(TAG, "Error writing to log file", e);
        }
    }
}
