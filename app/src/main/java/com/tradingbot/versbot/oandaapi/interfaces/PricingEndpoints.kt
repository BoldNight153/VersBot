package com.tradingbot.versbot.api.interfaces

interface PricingEndpoints : OandaApiService {
    fun getPricing(accountID: String): Unit
}