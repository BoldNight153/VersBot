package com.tradingbot.versbot.data.classes

data class CandlesResponse(
    val instrument: String,
    val granularity: String,
    val candles: List<Candle>
)

data class Candle(
    val complete: Boolean,
    val volume: Int,
    val time: String,
    val mid: CandleStick,
    val bid: CandleStick,
    val ask: CandleStick
)

data class CandleStick(
    val o: String,
    val h: String,
    val l: String,
    val c: String
)

data class OrderBookResponse(
    val orderBook: OrderBook,
    val lastTransactionID: String
)

data class PositionBookResponse(
    val positionBook: PositionBook,
    val lastTransactionID: String
)

data class PositionBucket(
    val price: String,
    val longCountPercent: String,
    val shortCountPercent: String
)

data class OrderBook( // Added missing class
    val instrument: String,
    val time: String,
    val price: String,
    val bucketWidth: String,
    val buckets: List<PositionBucket>
)

data class PositionBook( // Added missing class
    val instrument: String,
    val time: String,
    val price: String,
    val bucketWidth: String,
    val buckets: List<PositionBucket>
)