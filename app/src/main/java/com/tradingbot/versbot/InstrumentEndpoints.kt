package com.tradingbot.versbot

interface InstrumentEndpoints : OandaApiService {
    fun getInstruments(accountID: String): Unit
    fun getCandles(instrument: String): Unit
    fun getOrderBook(instrument: String): Unit
    fun getPositionBook(instrument: String): Unit
}