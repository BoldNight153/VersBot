package com.tradingbot.versbot.api.interfaces

interface TradeEndpoints : OandaApiService {
    fun getTradeList(accountID: String): Unit
    fun getOpenTrades(accountID: String): Unit
    fun getTradeDetails(accountID: String, tradeID: String): Unit
    fun closeTrade(accountID: String, tradeID: String): Unit
    fun closeTrades(accountID: String): Unit
}