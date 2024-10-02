package com.tradingbot.versbot

interface OandaApiService {
    val baseUrl: String
    val accessToken: String
    val contentType: String
}