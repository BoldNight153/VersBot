package com.tradingbot.versbot.data.classes

data class PriceListResponse(
    val prices: List<Price>,
    val time: String
)

data class Price(
    val type: String,
    val instrument: String,
    val time: String,
    val status: String,
    val tradeable: Boolean,
    val bids: List<PriceBucket>,
    val asks: List<PriceBucket>,
    val closeoutBid: String,
    val closeoutAsk: String,
    val quoteHomeConversionFactors: QuoteHomeConversionFactors
)

data class PriceBucket(
    val price: String,
    val liquidity: Int
)

data class QuoteHomeConversionFactors(
    val positiveUnits: String,
    val negativeUnits: String
)