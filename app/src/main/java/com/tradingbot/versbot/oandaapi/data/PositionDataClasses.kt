package com.tradingbot.versbot.data.classes

data class PositionListResponse(
    val positions: List<Position>,
    val lastTransactionID: String
)

data class Position(
    val instrument: String,
    val long: PositionSide?,
    val short: PositionSide?
)

data class PositionSide(
    val units: String,
    val averagePrice: String,
    val tradeIDs: List<String>,
    val pl: String,
    val unrealizedPL: String,
    val resettablePL: String
)

data class OpenPositionsResponse(
    val positions: List<Position>,
    val lastTransactionID: String
)

data class PositionDetailsResponse(
    val position: Position,
    val lastTransactionID: String
)

data class ClosePositionResponse(
    val longOrderCreateTransaction: Transaction?,
    val longOrderFillTransaction: Transaction?,
    val longOrderCancelTransaction: Transaction?,
    val shortOrderCreateTransaction: Transaction?,
    val shortOrderFillTransaction: Transaction?,
    val shortOrderCancelTransaction: Transaction?,
    val relatedTransactionIDs: List<String>,
    val lastTransactionID: String
)