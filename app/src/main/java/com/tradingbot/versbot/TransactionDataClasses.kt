package com.tradingbot.versbot

data class TransactionListResponse(
    val pages: List<String>,
    val lastTransactionID: String
)

data class TransactionDetailsResponse(
    val transaction: Transaction,
    val lastTransactionID: String
)

data class TransactionHeartbeatResponse(
    val type: String,
    val lastTransactionID: String,
    val time: String
)

data class TransactionIDRangeResponse(
    val transactions: List<Transaction>,
    val lastTransactionID: String
)

data class TransactionSinceIDResponse(
    val transactions: List<Transaction>,
    val lastTransactionID: String
)

data class TransactionStreamResponse(
    val transaction: Transaction
)

data class Transaction(
    val id: String,
    val time: String,
    val userID: Int,
    val accountID: String,
    val batchID: String,
    val requestID: String,
    val type: String,
    val alias: String? = null,
    val marginRate: String? = null,
    val instrument: String? = null,
    val units: String? = null,
    val price: String? = null,
    val timeInForce: String? = null,
    val gtdTime: String? = null,
    val positionFill: String? = null,
    val triggerCondition: String? = null,
    val takeProfitOnFill: TakeProfitOnFill? = null,
    val stopLossOnFill: StopLossOnFill? = null,
    val trailingStopLossOnFill: TrailingStopLossOnFill? = null,
    val tradeClose: TradeClose? = null,
    val clientExtensions: ClientExtensions? = null,
    val reason: String? = null,
    val tradeIDs: List<String>? = null,
    val clientTradeID: String? = null,
    val orderID: String? = null,
    val clientOrderID: String? = null,
    val replacedByOrderID: String? = null,
    val tradeOpened: TradeOpen? = null,
    val tradeReduced: TradeReduce? = null,
    val intendedReplacesOrderID: String? = null,
    val rejectReason: String? = null,
    val distance: String? = null,
    val trailingStopValue: String? = null,
    val guaranteed: Boolean? = null,
    val divisionID: Int? = null,
    val siteID: Int? = null,
    val accountUserID: Int? = null,
    val accountNumber: Int? = null,
    val homeCurrency: String? = null,
    val query: String? = null,
    val pageSize: Int? = null,
    val from: String? = null,
    val to: String? = null,
    val count: Int? = null,
    val longPositionCloseout: PositionCloseout? = null,
    val shortPositionCloseout: PositionCloseout? = null,
    val marginCloseout: MarginCloseout? = null,
    val delayedTradeClosure: DelayedTradeClosure? = null,
    val dailyFinancing: DailyFinancing? = null,
    val dividendAdjustment: DividendAdjustment? = null,
    val resetResettablePL: ResetResettablePL? = null
)

data class TakeProfitOnFill(
    val timeInForce: String,
    val price: String
)

data class StopLossOnFill(
    val timeInForce: String,
    val price: String,
    val guaranteed: Boolean?
)

data class TrailingStopLossOnFill(
    val timeInForce: String,
    val distance: String
)

data class TradeClose(
    val tradeID: String,
    val clientTradeID: String?
)

data class TradeOpen(
    val tradeID: String,
    val units: String,
    val clientTradeID: String?
)

data class TradeReduce(
    val tradeID: String,
    val units: String,
    val clientTradeID: String?
)

data class PositionCloseout(
    val instrument: String,
    val units: String,
    val price: String
)

data class MarginCloseout(
    val reason: String,
    val partial: Boolean
)

data class DelayedTradeClosure(
    val tradeID: String,
    val sourceTransactionID: String
)

data class DailyFinancing(
    val trades: List<DailyFinancingTrade>,
    val accountBalance: String,
    val accountFinancing: String
)

data class DailyFinancingTrade(
    val tradeID: String,
    val financing: String
)

data class DividendAdjustment(
    val instrument: String,
    val dividend: String,
    val units: String
)

data class ResetResettablePL(
    val accountBalance: String,
    val perUnitSpreadCost: String
)