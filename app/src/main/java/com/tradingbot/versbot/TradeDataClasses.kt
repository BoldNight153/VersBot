package com.tradingbot.versbot

import com.tradingbot.versbot.Transaction
import com.tradingbot.versbot.TakeProfitOnFill
import com.tradingbot.versbot.StopLossOnFill
import com.tradingbot.versbot.TrailingStopLossOnFill
import com.tradingbot.versbot.TradeClose
import com.tradingbot.versbot.ClientExtensions
import com.tradingbot.versbot.TradeOpen
import com.tradingbot.versbot.TradeReduce

data class TradeListResponse(
    val trades: List<Trade>,
    val lastTransactionID: String
)

data class Trade(
    val id: String,
    val instrument: String,
    val price: String,
    val openTime: String,
    val state: String,
    val initialUnits: String,
    val currentUnits: String,
    val realizedPL: String,
    val unrealizedPL: String,
    val marginUsed: String,
    val averageClosePrice: String?,
    val closingTransactionIDs: List<String>,
    val financing: String,
    val closeTime: String?,
    val clientExtensions: ClientExtensions?,
    val takeProfitOrder: TakeProfitOrder?,
    val stopLossOrder: StopLossOrder?,
    val trailingStopLossOrder: TrailingStopLossOrder?
)

data class ClientExtensions(
    val id: String,
    val tag: String?,
    val comment: String?
)

data class TakeProfitOrder(
    val id: String,
    val createTime: String,
    val state: String,
    val type: String,
    val tradeID: String,
    val clientTradeID: String?,
    val price: String,
    val timeInForce: String,
    val gtdTime: String?,
    val triggerCondition: String,
    val fillingTransactionID: String?,
    val filledTime: String?,
    val tradeClosedIDs: List<String>?,
    val cancellingTransactionID: String?,
    val cancelledTime: String?,
    val replacesOrderID: String?,
    val replacedByOrderID: String?
)

data class StopLossOrder(
    val id: String,
    val createTime: String,
    val state: String,
    val type: String,
    val tradeID: String,
    val clientTradeID: String?,
    val price: String?,
    val distance: String?,
    val timeInForce: String,
    val gtdTime: String?,
    val triggerCondition: String,
    val guaranteed: Boolean,
    val fillingTransactionID: String?,
    val filledTime: String?,
    val tradeClosedIDs: List<String>?,
    val cancellingTransactionID: String?,
    val cancelledTime: String?,
    val replacesOrderID: String?,
    val replacedByOrderID: String?
)

data class TrailingStopLossOrder(
    val id: String,
    val createTime: String,
    val state: String,
    val type: String,
    val tradeID: String,
    val clientTradeID: String?,
    val distance: String,
    val timeInForce: String,
    val gtdTime: String?,
    val triggerCondition: String,
    val trailingStopValue: String,
    val fillingTransactionID: String?,
    val filledTime: String?,
    val tradeClosedIDs: List<String>?,
    val cancellingTransactionID: String?,
    val cancelledTime: String?,
    val replacesOrderID: String?,
    val replacedByOrderID: String?
)

data class OpenTradesResponse(
    val trades: List<Trade>,
    val lastTransactionID: String
)

data class TradeDetailsResponse(
    val trade: Trade,
    val lastTransactionID: String
)

data class CloseTradeResponse(
    val orderCreateTransaction: Transaction,
    val orderFillTransaction: Transaction,
    val orderCancelTransaction: Transaction?,
    val relatedTransactionIDs: List<String>,
    val lastTransactionID: String
)

data class TradeCloseDetails(
    val tradeID: String,
    val units: String,
    val clientTradeID: String?
)

data class ClientExtensionsResponse(
    val clientExtensions: ClientExtensions,
    val lastTransactionID: String
)

data class SetClientExtensionsResponse(
    val setClientExtensionsTransaction: Transaction,
    val lastTransactionID: String
)

data class SetTradeDependentOrdersResponse(
    val takeProfitOrderCancelTransaction: Transaction?,
    val takeProfitOrderCreateTransaction: Transaction?,
    val takeProfitOrderFillTransaction: Transaction?,
    val takeProfitOrderReissueTransaction: Transaction?,
    val takeProfitOrderReissueRejectTransaction: Transaction?,
    val stopLossOrderCancelTransaction: Transaction?,
    val stopLossOrderCreateTransaction: Transaction?,
    val stopLossOrderFillTransaction: Transaction?,
    val stopLossOrderReissueTransaction: Transaction?,
    val stopLossOrderReissueRejectTransaction: Transaction?,
    val trailingStopLossOrderCancelTransaction: Transaction?,
    val trailingStopLossOrderCreateTransaction: Transaction?,
    val trailingStopLossOrderFillTransaction: Transaction?,
    val trailingStopLossOrderReissueTransaction: Transaction?,
    val trailingStopLossOrderReissueRejectTransaction: Transaction?,
    val relatedTransactionIDs: List<String>,
    val lastTransactionID: String
)