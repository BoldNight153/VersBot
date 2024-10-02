package com.tradingbot.versbot

interface PricingEndpoints : OandaApiService {
    fun getPricing(accountID: String): Unit
}