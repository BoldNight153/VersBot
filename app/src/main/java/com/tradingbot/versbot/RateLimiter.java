//package com.tradingbot.smatestbot2;
//
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class RateLimiter {
//
//    private static final int MAX_TOKENS = 120;
//    private static final int REFILL_TOKENS = 30;
//    private static final long REFILL_INTERVAL_MS = 250;
//
//    private int tokens;
//    private final Lock lock;
//    private final Condition tokensAvailable;
//
//    private static RateLimiter instance;
//
//    private RateLimiter() {
//        this.tokens = MAX_TOKENS;
//        this.lock = new ReentrantLock();
//        this.tokensAvailable = lock.newCondition();
//        startRefilling();
//    }
//
//    public static RateLimiter getInstance() {
//        if (instance == null) {
//            synchronized (RateLimiter.class) {
//                if (instance == null) {
//                    instance = new RateLimiter();
//                }
//            }
//        }
//        return instance;
//    }
//
//    public void acquireToken() throws InterruptedException {
//        lock.lock();
//        try {
//            while (tokens == 0) {
//                tokensAvailable.await();
//            }
//            tokens--;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    private void startRefilling() {
//        Thread refillThread = new Thread(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(REFILL_INTERVAL_MS);
//                    lock.lock();
//                    try {
//                        tokens = Math.min(tokens + REFILL_TOKENS, MAX_TOKENS);
//                        tokensAvailable.signalAll();
//                    } finally {
//                        lock.unlock();
//                    }
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        });
//        refillThread.setDaemon(true);
//        refillThread.start();
//    }
//}


package com.tradingbot.versbot;

import android.icu.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RateLimiter {

    private static final int MAX_TOKENS = 120;
    private static final int REFILL_TOKENS = 30;
    private static final long REFILL_INTERVAL_MS = 250;

    private int tokens;
    private final Lock lock;
    private final Condition tokensAvailable;

    private RateLimiter() {
        this.tokens = MAX_TOKENS;
        this.lock = new ReentrantLock();
        this.tokensAvailable = lock.newCondition();
        startRefilling();
    }

    private static final class InstanceHolder {
        static final RateLimiter instance = new RateLimiter();
    }

    public static RateLimiter getInstance() {
        return InstanceHolder.instance;
    }

    public void acquireToken() throws InterruptedException {
        lock.lock();
        try {
            while (tokens == 0) {
                tokensAvailable.await();
            }
            tokens--;
        } finally {
            lock.unlock();
        }
    }

    private void startRefilling() {
        Thread refillThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(REFILL_INTERVAL_MS);
                    lock.lock();
                    try {
                        tokens = Math.min(tokens + REFILL_TOKENS, MAX_TOKENS);
                        tokensAvailable.signalAll();
                    } finally {
                        lock.unlock();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log("Refill thread interrupted: " + e.getMessage());
                }
            }
        });
        refillThread.setDaemon(true);
        refillThread.start();
    }

    private void log(String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
        System.out.println(timestamp + " - " + message);
    }
}
