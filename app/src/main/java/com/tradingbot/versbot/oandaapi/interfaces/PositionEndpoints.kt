package com.tradingbot.versbot.api.interfaces

interface PositionEndpoints : OandaApiService {
    fun getPositionList(accountID: String): Unit
    fun getOpenPositions(accountID: String): Unit
    fun getPositionDetails(accountID: String, instrument: String): Unit
    fun closePosition(accountID: String, instrument: String): Unit
}